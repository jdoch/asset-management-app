package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerListEntryDTO {
    private String id;
    private String name;
    private String surname;

    public CustomerListEntryDTO(Customer customer) {
        id = customer.getId().toString();
        name = customer.getName();
        surname = customer.getSurname();
    }
}
