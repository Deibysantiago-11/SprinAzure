package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Equipo;

import java.math.BigInteger;
import java.util.List;

public interface EquipoDao {
    List<Equipo> getEquipos();

    void borrar(BigInteger sn);

    void guardar(Equipo equipo);
}
