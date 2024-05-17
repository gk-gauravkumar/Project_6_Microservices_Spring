package com.gk.userservices.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    private String userid;

    @Column(name = "Name", length = 20)
    private String userName;

    @Column(name = "Email")
    private String email;

    @Transient
    private List<Rating> Ratings = new ArrayList<Rating>();

}
