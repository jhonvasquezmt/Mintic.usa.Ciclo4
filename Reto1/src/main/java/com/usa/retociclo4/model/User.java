package com.usa.retociclo4.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author JhonV
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user", indexes = @Index(name= "indx_email",columnList = "user_email",unique = true))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email",nullable = false)
    private String email;
    @NonNull
    @Column(name = "user_password",nullable = false)
    private String password;
    @NonNull
    @Column(name = "user_name",nullable = false)
    private String name;
}
