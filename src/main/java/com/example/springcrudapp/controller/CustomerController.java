package com.example.springcrudapp.controller;

import com.example.springcrudapp.dto.CustomerDTO;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

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
                           @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/delete")
    public void add(@RequestParam String uuid) {
        customerService.delete(UUID.fromString(uuid));
    }
}
