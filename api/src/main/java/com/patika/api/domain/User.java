package com.patika.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -8577024754630506425L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String mail;

    @OneToMany(mappedBy = "user")
    private List<SaleAdvertisement> advertisementList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
