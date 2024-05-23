package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CompanyDTO {
    private String name;
    private Address address;
    private Set<Customer> customers = new HashSet<>();
    private List<Asset> assets = new ArrayList<>();
}
