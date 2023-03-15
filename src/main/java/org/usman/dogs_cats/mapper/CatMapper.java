package org.usman.dogs_cats.mapper;


import org.mapstruct.Mapper;
import org.usman.dogs_cats.dto.CatDto;

import org.usman.dogs_cats.model.Cat;

@Mapper(componentModel = "spring")
public interface CatMapper extends EntityMapper<CatDto,Cat>{
    CatDto toDto(Cat cat);
    Cat  toEntity(CatDto catDto);
}
