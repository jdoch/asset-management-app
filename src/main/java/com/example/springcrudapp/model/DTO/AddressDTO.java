package com.example.springcrudapp.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String houseNumber;
}
