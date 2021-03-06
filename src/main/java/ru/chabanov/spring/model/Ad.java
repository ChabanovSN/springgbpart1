package ru.chabanov.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.*;



@Entity
@Table(name="app_adv")
public class Ad  {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Size(min=2, max=150, message="{validation.title.size}")
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
    @Size(min=100, message="{validation.content.min}")
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
