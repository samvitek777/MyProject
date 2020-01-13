package com.example.myproject.domain;

import lombok.Data;

import javax.persistence.*;

/** User for security
 *
 * @author Samoylenko Victor
 * @version 1.0
 */

@Data
@Entity
@Table(name="usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String email;
}
