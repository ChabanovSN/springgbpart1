package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Entity
@Table(name="app_company")
public class Company {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(name = "name_company")
    private String name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    @OneToMany(mappedBy = "owner",fetch=FetchType.EAGER)
    private Set<Ad> ads = new HashSet<>();

}
