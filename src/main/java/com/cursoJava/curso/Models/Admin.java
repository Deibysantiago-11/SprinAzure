package com.cursoJava.curso.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "admi")
public class Admin {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "correo")
    private String correo;


    @Column(name = "password")
    private String password;

}
