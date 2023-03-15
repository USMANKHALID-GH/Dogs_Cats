package org.usman.dogs_cats.mapper;

import org.mapstruct.Mapper;
import org.usman.dogs_cats.dto.DogDto;
import org.usman.dogs_cats.model.Dog;

@Mapper(componentModel = "spring")
public interface DogMapper  extends EntityMapper<DogDto, Dog>{
    DogDto toDto(Dog dog);
    Dog toEntity(DogDto dogDto);
}
