package org.usman.dogs_cats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.usman.dogs_cats.utilities.ToLower;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Table(name = "dog_tbl")
public class Dog extends  AbstractModel{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dog_id")
    private Long id;
    @ToLower
    private String dogName;
    private LocalDate birthYear;
    @ToLower
    private String description;
    private String image;
    private  boolean availability;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "dog_bread" ,nullable = false)
    private Breed breed;
    private Float price;
}
