package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="app_adv")
@ToString
public class Ad {
     @ToString.Exclude
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

     @ToString.Exclude
    @Setter
    @Getter
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company owner;

    @ToString.Exclude
    @Setter
    @Getter
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "ad_category",
            joinColumns = {@JoinColumn(name = "ad_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
       private Set<Category> categories = new HashSet<>();

    @Setter
    @Getter
    @Column(name = "name_of_ad")
    private String name;

    @Setter
    @Getter
    @Column(length = 500)
    private String content;

    @Setter
    @Getter
    private String number;


}
