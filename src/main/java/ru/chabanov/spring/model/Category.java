package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name="app_category")
public class Category extends Common {


    @Setter
    @Getter
    @ManyToMany(mappedBy = "categories", fetch = LAZY,cascade = CascadeType.ALL)
    private Set<Ad> ads= new HashSet<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
           //     ", ads=" + printSet(ads) +
                '}';
    }
    private String printSet(Set<Ad> set){
        StringBuilder setString = new StringBuilder();
        setString.append("\n");
        set.forEach(m -> setString.append(m).append("\n"));
        return setString.toString();
    }
}
