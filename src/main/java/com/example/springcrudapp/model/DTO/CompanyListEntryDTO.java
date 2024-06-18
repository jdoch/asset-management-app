package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CompanyListEntryDTO {
    private UUID id;
    private String name;

    public CompanyListEntryDTO(Company company) {
        id = company.getId();
        name = company.getName();
    }
}
