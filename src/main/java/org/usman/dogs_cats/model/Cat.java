package org.usman.dogs_cats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.NumberFormat;
import org.usman.dogs_cats.utilities.ToLower;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Table(name = "cat_tbl")
public class Cat extends AbstractModel {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "Cat name cant be empty")
    @ToLower
    private String catName;
    private LocalDate birthYear;
    @ToLower
    private String description;
    private String image;
    private  boolean availability;
    @NumberFormat
    private Float price;
    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_bread",nullable = false)
    private Breed breed;
}
