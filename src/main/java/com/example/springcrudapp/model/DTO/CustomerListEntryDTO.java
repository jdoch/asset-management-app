package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerListEntryDTO {
    private UUID id;
    private String name;
    private String surname;

    public CustomerListEntryDTO(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        surname = customer.getSurname();
    }
}
