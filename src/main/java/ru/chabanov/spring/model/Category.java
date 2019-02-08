package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Entity
@Table(name="app_category")
public class Category {

    @ToString.Exclude
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(name = "name_of_category")
    private String name;

    @ToString.Exclude
    @Setter
    @Getter
    @ManyToMany(mappedBy = "categories",fetch=FetchType.EAGER)
    private Set<Ad> ads= new HashSet<>();
}
