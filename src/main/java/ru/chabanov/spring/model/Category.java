package ru.chabanov.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name="app_category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ad", propOrder = {
        "id",
        "name",
        "version",
        "ads",


})
public class Category  {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Version
    private Integer version;

    @Setter
    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "categories", fetch = LAZY)
    @XmlElementWrapper(name = "ads")
    @XmlElements({
            @XmlElement(name = "ad", type = Ad.class)
    })
    private List<Ad> ads;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
           //     ", ads=" + printSet(ads) +
                '}';
    }
    private String printSet(List<Ad> set){
        StringBuilder setString = new StringBuilder();
        setString.append("\n");
        set.forEach(m -> setString.append(m).append("\n"));
        return setString.toString();
    }
}
