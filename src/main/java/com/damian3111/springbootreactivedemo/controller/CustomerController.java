package com.damian3111.springbootreactivedemo.controller;

import com.damian3111.springbootreactivedemo.dto.CustomerDTO;
import com.damian3111.springbootreactivedemo.entity.Customer;
import com.damian3111.springbootreactivedemo.repository.CustomerRepository;
import com.damian3111.springbootreactivedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;
import java.util.stream.Stream;


@RequiredArgsConstructor
@RequestMapping(path = "/stream")
@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping("/customer/{id}")
    public Mono<Customer> getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id)
                .log();
    }

    @GetMapping(path = "/customers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomers(){
        return customerService.getCustomers()
                .delayElements(Duration.ofSeconds(4));
    }

    @PostMapping("/customer")
    public Mono<Customer> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/customer")
    public Mono<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO){

        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customer/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") Long id){
        return customerService.deleteCustomer(id);
    }
}
