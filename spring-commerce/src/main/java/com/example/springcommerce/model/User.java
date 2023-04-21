package com.example.springcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    private String username;

    private String password;

    private String role;
}
