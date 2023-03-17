package org.usman.dogs_cats.service.implementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.usman.dogs_cats.error.IdOrNameNotFound;
import org.usman.dogs_cats.model.Breed;
import org.usman.dogs_cats.repository.BreedRepository;
import org.usman.dogs_cats.service.BreedService;


@Service
@RequiredArgsConstructor
@Slf4j
public class BreedImp implements BreedService {
    private final BreedRepository breedRepository;

    @Override
    public void createBreed(@Valid Breed breed) {
        log.info("inside service class"+ breed);
        breedRepository.save(breed);
    }

    @Override
    public Page<Breed> showAllBreed(Pageable pageable) {
        return   breedRepository.findAll(pageable);
    }

    @Override
    public Breed findByBreedName(String name) {
        return breedRepository.findBreadByBreedNameIgnoreCase(name).orElseThrow(()->new IdOrNameNotFound("there is  no such %s in our system".formatted(name)));
    }

    @Override
    public Breed findById(Long _long) {
        return breedRepository.findById(_long).orElseThrow(()->new IdOrNameNotFound("there is such no %d in our system".formatted(_long)));
    }

    @Override
    public void updateBreed(Long id, @Valid Breed breed) {
        Breed newBreed = breedRepository.findById(id).orElseThrow(()->new IdOrNameNotFound("there is such no %d in our system".formatted(id)));
        if (!(breed.getBreedName().isBlank() || breed.getBreedName()==null)){
            newBreed.setBreedName(breed.getBreedName());
        }
        breedRepository.save(newBreed);

    }

    @Override
    public void deleteBreedById(Long id) {
        Breed breed = breedRepository.findById(id).orElseThrow(()->new IdOrNameNotFound("there is no such  %d in our system".formatted(id)));
        breedRepository.delete(breed);
    }
}
