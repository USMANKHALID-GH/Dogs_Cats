package org.usman.dogs_cats.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.usman.dogs_cats.error.IdOrNameNotFound;
import org.usman.dogs_cats.model.Cat;
import org.usman.dogs_cats.model.Dog;
import org.usman.dogs_cats.repository.CatRepository;
import org.usman.dogs_cats.service.CatService;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class CatImp implements CatService {

    private final CatRepository catRepository;


    @Override
    public void createCat(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public List<Cat> showAllcat(Pageable pageable) {
        return catRepository.findAll(pageable)
                .stream()
                .filter(CatImp::isavailable).collect(Collectors.toList());
    }

    @Override
    public List<Cat> showAllCatNotAvailable(Pageable pageable) {
        return catRepository.findAll(pageable)
                .stream()
                .filter(Predicate.not(CatImp::isavailable)).collect(Collectors.toList());
    }

    @Override
    public Page<Cat> findByCatByBreedName(Pageable pageable, String name) {

        return  catRepository.findCatsByBreedName(pageable,name);
    }

    @Override
    public Cat findByCatId(Long id) {
        return catRepository.findById(id)
                .orElseThrow(()-> new IdOrNameNotFound("there is no such  %d in our system".formatted(id)));
    }

    @Override
    public void updateCat(Long id, Cat cat) {
        Cat cat1=findByCatId(id);
        if(!(cat.getImage().isBlank()  || cat.getImage()==null)){
            cat1.setImage(cat.getImage());
        }

        if(!(cat.getDescription().isBlank()|| cat.getDescription()==null)){
            cat1.setDescription(cat.getDescription());
        }

        if(!(cat.getCatName().isBlank() || cat.getCatName()==null)){
            cat1.setCatName(cat.getCatName());
        }

        catRepository.save(cat1);
    }

    @Override
    public void deleteCatById(Long id) {
        Cat cat=findByCatId(id);
        catRepository.delete(cat);
    }

    @Override
    public Page<Object> findAllCatAndDogByAvailability(Pageable pageable) {
        return  catRepository.findAllCatAndDogByAvailability(pageable);
    }


    private static boolean isavailable(Cat cat){
        return cat.isAvailability();
    }
}
