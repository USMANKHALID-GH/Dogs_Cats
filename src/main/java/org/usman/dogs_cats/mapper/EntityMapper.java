package org.usman.dogs_cats.mapper;

import org.usman.dogs_cats.dto.BaseDto;
import org.usman.dogs_cats.model.AbstractModel;

import java.util.List;

public interface EntityMapper  <D extends BaseDto, E extends AbstractModel> {

    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
