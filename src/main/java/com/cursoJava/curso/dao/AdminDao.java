package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Admin;


public interface AdminDao {
     Admin verificarCredenciales(Admin admin);

    void Guardar(Admin admin);
}