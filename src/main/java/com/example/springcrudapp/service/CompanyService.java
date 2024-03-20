package com.example.springcrudapp.service;

import com.example.springcrudapp.model.*;
import com.example.springcrudapp.repository.AddressRepository;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.repository.CompanyRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final AssetRepository assetRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository,
                          CustomerRepository customerRepository, AssetRepository assetRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.assetRepository = assetRepository;
    }

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }
    public List<Company> findAllCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);

        Root<Company> root = criteriaQuery.from(Company.class);
        criteriaQuery.select(root);

        //Fetch<Company, Asset> assetJoin = root.fetch(Company_.assets, JoinType.LEFT);
        //Fetch<Company, Address> addressJoin = root.fetch(Company_.address, JoinType.LEFT);
        /*Fetch<Company, Customer> customerJoin = root.fetch(Company_.customers, JoinType.LEFT);
        Fetch<Customer, Address> customerAddressJoin = customerJoin.fetch(Customer_.address, JoinType.LEFT);*/

        TypedQuery<Company> query = entityManager.createQuery(criteriaQuery);
        List<Company> list = query.getResultList();
        return null;
    }

    @Transactional
    public Company save(Company company) {
        company.setId(null);
        /*addressRepository.save(company.getAddress());
        company.getAddress().setStreet("CustomStreeeet");
        customerRepository.saveAll(company.getCustomers());
        assetRepository.saveAll(company.getAssets());*/
        return companyRepository.save(company);
    }
}
