package com.damian3111.springbootreactivedemo.service;

import com.damian3111.springbootreactivedemo.dto.CustomerDTO;
import com.damian3111.springbootreactivedemo.entity.Customer;
import com.damian3111.springbootreactivedemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Mono<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> saveCustomer(CustomerDTO customerDTO) {

        return customerRepository.save(mapToCustomer(customerDTO));
    }

    public Mono<Customer> updateCustomer(CustomerDTO customerDTO) {
        return customerRepository.findById(customerDTO.getId())
                .map(c -> {
                    c.setAge(customerDTO.getAge());
                    c.setName(customerDTO.getName());
                    c.setEmail(customerDTO.getEmail());
                    return c;
                })
                .flatMap(customerRepository::save);
    }

    public Mono<Void> deleteCustomer(Long id){
        return customerRepository.deleteById(id);
    }

    private static Customer mapToCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .email(customerDTO.getEmail())
                .build();
    }
}
