package com.damian3111.springbootreactivedemo.repository;

import com.damian3111.springbootreactivedemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

}
