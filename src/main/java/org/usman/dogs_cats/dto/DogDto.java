package org.usman.dogs_cats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.usman.dogs_cats.model.Breed;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDto implements  BaseDto{
    private String dogName;
    private LocalDate birthYear;
    private String description;
    private String image;
    private  boolean availability;
    private Breed breed;
    private Float price;
}
