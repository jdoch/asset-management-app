package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Company;
import com.example.springcrudapp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public List<Company> getAll() {
        return companyService.findAllCriteriaQuery();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Company add(@RequestBody Company company) {
        return companyService.save(company);
    }
}
