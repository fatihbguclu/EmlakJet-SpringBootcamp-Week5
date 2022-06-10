package com.patika.api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class SaleAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String photo;
    private String details;
    private String price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
