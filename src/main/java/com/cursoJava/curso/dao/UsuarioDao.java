package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Usuario;

import java.math.BigInteger;
import java.util.List;

public interface UsuarioDao {

     List<Usuario> getUsuarios();

     void eliminar(BigInteger id);

    void registrar(Usuario usuario);
}
