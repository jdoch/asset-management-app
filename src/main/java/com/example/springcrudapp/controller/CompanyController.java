package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Company;
import com.example.springcrudapp.model.DTO.CompanyDTO;
import com.example.springcrudapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAll")
    public Iterable<Company> getAll() {
        return companyService.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Company add(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }

    @PutMapping("/update")
    public Company update(@RequestParam UUID id,
                          @RequestBody CompanyDTO companyDTO) {
        return companyService.update(id, companyDTO);
    }
}
