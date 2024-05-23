package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {
    private String name;
    private Address address;
}
