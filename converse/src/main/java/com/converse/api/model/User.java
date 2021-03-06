package com.converse.api.model;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.File;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="users")

public class User {

    //@Column(name="id", updatable = false)
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId=UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
}