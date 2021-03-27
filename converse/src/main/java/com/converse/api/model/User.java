package com.converse.api.model;


import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Data
@AllArgsConstructor
//@Embeddable
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private File profilePicture;
    private String password;
}