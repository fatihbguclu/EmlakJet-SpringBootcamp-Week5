package com.patika.api.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDTO {

    private String title;
    private String photo;
    private String details;
    private String price;
    private String graphPath;

    private UserDTO user;
}
