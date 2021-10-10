package com.shakeer.company.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "random_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


}
