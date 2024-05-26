package com.example.springcrudapp.model.DTO;

import com.example.springcrudapp.model.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyListEntryDTO {
    private String id;
    private String name;

    public CompanyListEntryDTO(Company company) {
        id = company.getId().toString();
        name = company.getName();
    }
}
