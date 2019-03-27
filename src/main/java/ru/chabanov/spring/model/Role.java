package ru.chabanov.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="role")
public class Role {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    @Getter
    @Setter
    private Integer id;

    @Column(name="name")
    @Getter
    @Setter
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="role", fetch=FetchType.LAZY)
            @Getter
            @Setter
    List<Company> authors;


}