package com.patika.api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class SaleAdvertisement implements Serializable {

    private static final long serialVersionUID = -5483390214395653823L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String photo;
    private String details;
    private String price;
    private String graphPath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
