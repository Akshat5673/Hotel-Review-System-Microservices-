package com.nineleaps.user.UserService.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_users")
@Builder
public class User {

    @Id
    private String userId;
    @Column(length = 100, nullable = false, unique = true)
    private String name;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 600)
    private String about;

    @Transient  // used when we want to specify that this does not have to be stored in DB
    private List<Rating> ratings = new ArrayList<>();

}
