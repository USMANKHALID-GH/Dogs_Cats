package org.usman.dogs_cats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.usman.dogs_cats.utilities.ToLower;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Table(name = "breed")
public class Breed extends  AbstractModel{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "breed_id")
    private Long id;

    @Column(name = "breed_name",unique = true,nullable = false)
    @ColumnTransformer(read = "LOWER(breed_name)", write = "LOWER(?)")
    private String breedName;


//    @Column(name = "breed_name", unique = true, nullable = false)
//    @ColumnTransformer(read = "LOWER(breed_name)", write = "LOWER(CONCAT(?, '_unique'))")
//    private String breedName;

}
