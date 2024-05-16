package com.gk.hotelservices.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("hotel")
public class Hotel {
    @Id
    private String id;

    private String name;

    private String location;

    private String about;

}
