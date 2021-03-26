package com.converse.api.model;


import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    //UUid ?
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    @Embedded
    private Schedule schedule;
    private File profilePicture;
    private String password;
}