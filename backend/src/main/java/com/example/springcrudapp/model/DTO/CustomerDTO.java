package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String surname;
    private AddressDTO address;
    private List<Company> companies;
}
