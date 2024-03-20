package com.example.springcrudapp.service;

import com.example.springcrudapp.dto.CustomerDTO;
import com.example.springcrudapp.exception.CustomerNotFound;
import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.repository.AddressRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Object[] getMinMaxBuildingNumber() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Customer> customer = cq.from(Customer.class);
        var address = customer.join("address", JoinType.LEFT);
        cq.multiselect(
                cb.max(address.get("buildingNumber").as(Long.class)),
                cb.min(address.get("buildingNumber").as(Long.class)));
        //Predicate namePredicate = cb.equal(customer.get("name"), "Jan");
        //cq.where(namePredicate);
        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());

        Address address = customerDTO.getAddress();
        if (address != null) {
            customer.setAddress(address);
            addressRepository.save(address);
        }
        return customerRepository.save(customer);
    }

    public Customer update(UUID id, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
        customer.setName(updatedCustomer.getName());
        customer.setSurname(updatedCustomer.getSurname());
        return customerRepository.save(customer);
    }

    public void delete(UUID id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFound();
        }
        customerRepository.deleteById(id);
    }
}
