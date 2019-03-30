package ru.chabanov.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import java.util.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="app_adv")
@NoArgsConstructor
public class Ad  {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Size(min=2, max=150, message="{validation.article.title.size}")
    private String name;

    @Getter
    @Version
    private Integer version;

    @Setter
    @Getter
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    @Valid
    private Company company;

    @Setter
    @Getter
    @Column(name="published_date", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date publishedDate;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category categories ;

    @Setter
    @Getter
    @Size(min=100, message="{validation.article.content.size}")
    private String content;

    @Setter
    @Getter
    private String number;

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + getId() +
               ", owner=" + company.getName() +
                ", date=" + publishedDate +
               ", categories=" + categories +
                ", name='" + getName() + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}
