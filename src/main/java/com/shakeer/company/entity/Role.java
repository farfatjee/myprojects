package com.shakeer.company.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="app_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Column(name="role_name")
    private String roleName;

}
