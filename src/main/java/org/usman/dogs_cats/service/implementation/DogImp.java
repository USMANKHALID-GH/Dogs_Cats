package org.usman.dogs_cats.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.usman.dogs_cats.error.IdOrNameNotFound;
import org.usman.dogs_cats.model.Dog;
import org.usman.dogs_cats.repository.DogRepository;
import org.usman.dogs_cats.service.DogService;


import java.util.List;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j

public class DogImp implements DogService {

    private final DogRepository dogRepository;

    @Override
    public void createDog(Dog dog) {

        log.info("\nservice class............................"+dog.getDogName());
        dogRepository.save(dog);
    }


    @Override
    public List<Dog> showAllBreed(Pageable pageable) {
        log.info("is working...............\n");
       return dogRepository.findAll(pageable).stream().filter(dog -> dog.isAvailability())
                .collect(Collectors.toList());
    }

    @Override
    public Page<Dog> findByDogByBreedName(Pageable pageable, String name) {
        return dogRepository.findDogsByBreedNameIgnoreCase(pageable,name);

}

    @Override
    public Dog findByDogId(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(()-> new IdOrNameNotFound("there is no such  %d in our system".formatted(id)));
    }

    @Override
    public void updateDog(Long id, Dog dog) {
        Dog dog1=findByDogId(id);
        if(!(dog.getImage().isBlank()  || dog.getImage()==null)){
            dog1.setImage(dog.getImage());
        }

        if(!(dog.getDescription().isBlank()|| dog.getDescription()==null)){
            dog1.setDescription(dog.getDescription());
        }

        if(!(dog.getDogName().isBlank() || dog.getDogName()==null)){
            dog1.setDogName(dog.getDogName());
        }

        dogRepository.save(dog1);

    }

    @Override
    public void deleteDogById(Long id) {
        Dog dog=findByDogId(id);
        dogRepository.delete(dog);

    }

    @Override
    public void updatePrice(Long id, Dog dog) {
        Dog dog1=findByDogId(id);
        if(!(dog.getPrice()<0|| dog.getPrice()==null)){
            dog1.setPrice(dog.getPrice());
        }
           dogRepository.save(dog1);
      }

    @Override
    public void buyPrice(Long id) {
        Dog dog=findByDogId(id);
        if(dog.isAvailability()){
            buy();
            log.info("\nbuying........................");
            dog.setAvailability(false);
            dogRepository.save(dog);
        }
        else
            throw new IdOrNameNotFound("the dog with id %d is not available".formatted(id));
    }

    @Override
    public void updateAvailability(Long id, Dog dog) {
        Dog dog1=findByDogId(id);
        dog1.setAvailability(dog.isAvailability());
        dogRepository.save(dog1);
    }

    @Override
    public List<Dog> showAllDogNotAvailable(Pageable pageable) {
        return dogRepository.findAll(pageable).stream().filter(dog -> !dog.isAvailability())
                .collect(Collectors.toList());
    }

    @Override
    public Page<Dog> findDogBysearchingInDescription(Pageable pageable,String string) {
        return dogRepository.findDogsByDescriptionContainingIgnoreCase(pageable,string);
    }


    private void buy() {
        log.info("\nthis is finish");
    }


}
