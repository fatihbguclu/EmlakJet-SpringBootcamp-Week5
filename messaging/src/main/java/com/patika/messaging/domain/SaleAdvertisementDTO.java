package com.patika.messaging.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SaleAdvertisementDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String photo;
    private String details;
    private String price;
    private String graphPath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDTO user;
}
