package com.example.springcrudapp.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String surname;
    private AddressDTO address;
}
