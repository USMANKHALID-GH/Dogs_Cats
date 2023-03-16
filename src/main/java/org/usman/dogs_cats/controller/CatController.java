package org.usman.dogs_cats.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.usman.dogs_cats.dto.CatDto;
import org.usman.dogs_cats.dto.DogDto;
import org.usman.dogs_cats.dto.ResponseDto;
import org.usman.dogs_cats.mapper.CatMapper;
import org.usman.dogs_cats.model.Cat;
import org.usman.dogs_cats.service.CatService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/cat")
public class CatController {

    private final CatService service;
    private final CatMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> createDog(@RequestBody CatDto catDto){

        service.createCat(mapper.toEntity(catDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Cat is Created Successfully").build());

    }


    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Page<CatDto>> showAllcat(Pageable pageable){

        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.showAllcat(pageable))));

    }

    @GetMapping("/not_available")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Page<CatDto>> showAllDogNotAvailable(Pageable pageable){

        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.showAllCatNotAvailable(pageable))));

    }


    @GetMapping("/{name}/name")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public  ResponseEntity<Page<CatDto>>  findByDogsByDogName(Pageable pageable,@PathVariable("name") String name){
        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.findByCatByBreedName(pageable,name).getContent())));
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public  ResponseEntity<CatDto>  findByDogId(@PathVariable("id") Long id){
        return   ResponseEntity.ok(mapper.toDto(service.findByCatId(id)));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseDto>  updateDog(@PathVariable("id") Long id, @RequestBody CatDto catDto){
        service.updateCat(id, mapper.toEntity(catDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is deleted Successfully").build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<ResponseDto>  deleteDogById(@PathVariable("id") Long id){
        service.deleteCatById(id);
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is deleted Successfully").build());
    }


    @GetMapping("/all_cats_and_dog_available")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public  ResponseEntity<Page<Object>>  findAllCatsAndDogsByAvailability(Pageable pageable){
        return  ResponseEntity.ok(new PageImpl<>(service.findAllCatAndDogByAvailability(pageable).getContent()));
    }



}
