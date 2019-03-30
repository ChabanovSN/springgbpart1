package ru.chabanov.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name="app_company")
@NamedEntityGraph(
        name = "Graph.Company",
        includeAllAttributes = true,
        attributeNodes = {

                @NamedAttributeNode(value = "ads", subgraph = "Company.Subgraph.ads")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "Company.Subgraph.ads",
                        type = Ad.class,
                        attributeNodes = {
                                @NamedAttributeNode(value = "categories")
                        }
                )},
        subclassSubgraphs = {
                @NamedSubgraph(
                        name = "Company.Subgraph.ads",
                        type = Category.class,

                        attributeNodes = {
                                @NamedAttributeNode(value = "name")
                        }
                )
        }

)
@NoArgsConstructor
public class Company  {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
   // @Pattern(regexp="[a-zA-z]+([ '-][a-zA-Z]+)*",message="{validation.author.lastname.pattern}")
    @Size(min=2, max=50, message="{validation.author.lastname.size}")
    private String name;

    @ManyToOne
    @JoinColumn(name="role_id")
    @Getter
    @Setter
    private Role role;

  //  @Pattern(regexp="^[a-zA-Z0-9._-]{3,}$", message="{validation.author.login.pattern}")
    @Column(name="login")
    @Getter
    @Setter
    private String login;

  //  @Pattern(regexp=".{8,}", message="{validation.author.password.pattern}")
    @Column(name="password")
    @Getter
    @Setter
    private String password;

    @Getter
    @Version
    private Integer version;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    @OneToMany(mappedBy = "company",fetch = LAZY)
    @JsonIgnore
    private List<Ad> ads;

//    @Override
//    public String toString() {
//        return "Company{" +
//                "id=" + getId() +
//                ", name='" +getName() + '\'' +
//                ", description='" + description + '\'' +
//                ", address='" + address + '\'' +
//                ", ads=" + printSet(ads) +
//                '}';
//    }

    private String printSet(List set){
        StringBuilder setString = new StringBuilder();
        setString.append("\n");
       set.forEach(m -> setString.append(m).append("\n"));
        return setString.toString();
    }
}
