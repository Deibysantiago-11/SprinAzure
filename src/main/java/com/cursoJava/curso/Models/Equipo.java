package com.cursoJava.curso.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "computo")
public class Equipo {

    @Id
    @Column(name = "sn")
    private BigInteger SN;

    @Column(name = "marca")
    private  String Marca;

    @Column(name = "procesador")
    private  String Procesador;

    @Column(name = "ram")
    private  String Ram;

    @Column(name = "sistema")
    private  String Sistema;

    @Column(name = "disco")
    private  String Disco;

    @Column(name = "puertos")
    private  String Puertos;
}
