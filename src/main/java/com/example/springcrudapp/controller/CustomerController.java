package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.DTO.CustomerDTO;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getAll")
    public Iterable<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PutMapping("/update")
    public Customer update(@RequestParam UUID id,
                           @RequestBody CustomerDTO customerDTO) {
        return customerService.update(id, customerDTO);
    }

    @DeleteMapping("/delete")
    public void add(@RequestParam String id) {
        customerService.delete(UUID.fromString(id));
    }
}
