package com.cursoJava.curso.Models;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {


    @Column(name = "id")
    @Id
    private BigInteger ID;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellido")
    private String Apellido;

    @Column(name = "documento")
    private String Documento;

    @Column(name = "genero")
    private String Genero;

   @Column(name = "nacionalidad")
    private String Nacionalidad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String Email;

    @Column(name = "telefono")
    private String Telefono;


}