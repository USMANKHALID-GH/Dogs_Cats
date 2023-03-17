package org.usman.dogs_cats.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.usman.dogs_cats.dto.DogDto;
import org.usman.dogs_cats.dto.ResponseDto;
import org.usman.dogs_cats.mapper.DogMapper;
import org.usman.dogs_cats.service.DogService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/dog")
public class DogController {

    private final DogService service;
    private final DogMapper mapper;


    @PostMapping("/")
    public ResponseEntity<ResponseDto> createDog(@RequestBody DogDto dogDto){
        log.info("\n......................"+dogDto.getDogName());
        service.createDog(mapper.toEntity(dogDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is Created Successfully").build());

    }


    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Page<DogDto>> showAllDog(Pageable pageable){

        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.showAllBreed(pageable))));

    }

    @GetMapping("/not_available")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Page<DogDto>> showAllDogNotAvailable(Pageable pageable){

        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.showAllDogNotAvailable(pageable))));

    }


    @GetMapping("/{name}/name")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public  ResponseEntity<Page<DogDto>>  findByDogsByDogName(Pageable pageable,@PathVariable("name") String name){
        return  ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.findByDogByBreedName(pageable,name).getContent())));
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public  ResponseEntity<DogDto>  findByDogId(@PathVariable("id") Long id){
        return   ResponseEntity.ok(mapper.toDto(service.findByDogId(id)));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseDto>  updateDog(@PathVariable("id") Long id, @RequestBody DogDto dogDto){
        service.updateDog(id, mapper.toEntity(dogDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is deleted Successfully").build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<ResponseDto>  deleteDogById(@PathVariable("id") Long id){
        service.deleteDogById(id);
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is deleted Successfully").build());
    }

    @PatchMapping("/{id}/price")
    public  ResponseEntity<ResponseDto>  updatePrice(@PathVariable("id") Long id, @RequestBody DogDto dogDto){
        service. updatePrice(id, mapper.toEntity(dogDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog's price is updated Successfully").build());
    }

    @PatchMapping("/{id}/availability")
    public  ResponseEntity<ResponseDto>  updateAvailability(@PathVariable("id") Long id, @RequestBody DogDto dogDto){
        service.updateAvailability(id, mapper.toEntity(dogDto));
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog's availability is updated Successfully").build());
    }





    @GetMapping("/{id}/buy")
    public  ResponseEntity<ResponseDto>  buyDog(@PathVariable("id") Long id){
        service. buyPrice(id);
        return  ResponseEntity.ok(ResponseDto.builder().message("Dog is bought Successfully").build());
    }


    @GetMapping("/{search}/searchning_in_description")
    public  ResponseEntity<Page<DogDto>> findBySearchingInDescription(Pageable pageable, @PathVariable("search") String search){
       log.info("\ndog............."+search);
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.findDogBysearchingInDescription(pageable,search).getContent())));
    }


}
