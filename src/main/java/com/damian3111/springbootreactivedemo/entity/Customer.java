package com.damian3111.springbootreactivedemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table
public class Customer {

    @Id
    private Long id;
    private String name;
    private String email;
    private short age;

}
