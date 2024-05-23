package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String surname;
    private Address address;
}
