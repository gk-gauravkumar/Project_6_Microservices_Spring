package com.gk.userservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

}
