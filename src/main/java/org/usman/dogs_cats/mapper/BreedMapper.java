package org.usman.dogs_cats.mapper;

import org.mapstruct.Mapper;
import org.usman.dogs_cats.dto.BreedDto;
import org.usman.dogs_cats.model.Breed;

@Mapper(componentModel = "spring")
public interface BreedMapper extends EntityMapper<BreedDto, Breed> {
    BreedDto toDto(Breed breed);
    Breed toEntity(BreedDto breedDto);
}
