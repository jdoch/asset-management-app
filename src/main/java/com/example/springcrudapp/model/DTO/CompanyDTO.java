package com.example.springcrudapp.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {
    private String name;
    private AddressDTO address;
}
