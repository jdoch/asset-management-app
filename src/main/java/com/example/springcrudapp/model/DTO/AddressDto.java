package com.example.springcrudapp.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class AddressDto {
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String houseNumber;
}
