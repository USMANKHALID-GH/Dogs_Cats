package org.usman.dogs_cats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BreedDto implements BaseDto{
    private String breedName;
}
