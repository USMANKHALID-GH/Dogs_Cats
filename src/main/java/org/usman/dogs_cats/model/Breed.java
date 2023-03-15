package org.usman.dogs_cats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@Table(name = "breed_tbl")
public class Breed extends  AbstractModel{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "breed_id")
    private Long id;
    @ToLower
    @Column(unique = true,nullable = false)
    @NotNull(message = "Breed cant be null")
    private String breedName;

}
