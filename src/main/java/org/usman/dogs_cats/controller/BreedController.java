package org.usman.dogs_cats.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.usman.dogs_cats.dto.BreedDto;
import org.usman.dogs_cats.dto.ResponseDto;
import org.usman.dogs_cats.mapper.BreedMapper;
import org.usman.dogs_cats.service.BreedService;




@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/breed")
public class BreedController {
    private  final BreedService service;
    private  final BreedMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> createBreed(@RequestBody BreedDto breedDto){
        log.info("\n in the controller...................................."+ breedDto.toString());
           service.createBreed(mapper.toEntity(breedDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Breed is Created Successfully").build());

    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Page<BreedDto>> showAllBreed(Pageable pageable){

        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.showAllBreed(pageable).getContent())));

    }

    @GetMapping("/{name}/name")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public  ResponseEntity<BreedDto>  findByBreedName(@PathVariable("name") String name){
       return  ResponseEntity.ok(mapper.toDto(service.findByBreedName(name)));
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public  ResponseEntity<BreedDto>  findByBreedId(@PathVariable("id") Long id){
        return   ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseDto>  updateBreed(@PathVariable("id") Long id, @RequestBody BreedDto breedDto){
          service.updateBreed(id, mapper.toEntity(breedDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Breed is deleted Successfully").build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<ResponseDto>  deleteBreedById(@PathVariable("id") Long id){
        service.deleteBreedById(id);
        return  ResponseEntity.ok(ResponseDto.builder().message("Breed is deleted Successfully").build());
    }



}
