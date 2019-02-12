package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="app_adv")

@NamedQueries({
        @NamedQuery(name="Ad.findAllAds",query = "select e from Ad e"),
        @NamedQuery(name="Ad.findById",query = "select distinct e from Ad e  where e.id = :id")
})
public class Ad extends Common {




    @Setter
    @Getter
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company owner;


    @Setter
    @Getter
    @ManyToMany(fetch = LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "ad_category",
            joinColumns = {@JoinColumn(name = "ad_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<>();



    @Setter
    @Getter
    @Column(length = 500)
    private String content;

    @Setter
    @Getter
    private String number;

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + getId() +
               ", owner=" + owner.getName() +
               ", categories=" + printSet(categories) +
                ", name='" + getName() + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
    private String printSet(Set<Category> set){
        StringBuilder setString = new StringBuilder();
        setString.append("\n");
        set.forEach(m -> setString.append(m.getName()).append("\n"));
        return setString.toString();
    }
}
