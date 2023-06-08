package org.usman.dogs_cats.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String country;
    private String city;
    private String streedCode;
    private  String streedName;
    private String houseNumber;
    private int appartmentNumber;
}
