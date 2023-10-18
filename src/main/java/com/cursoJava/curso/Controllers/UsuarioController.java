package com.cursoJava.curso.Controllers;
import com.cursoJava.curso.Models.Usuario;
import com.cursoJava.curso.dao.UsuarioDao;
import com.cursoJava.curso.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@RestController
public class UsuarioController {

  PreparedStatement ps;
  ResultSet rs;

  @Autowired
  private UsuarioDao usuarioDao;

  private JWTutil jwTutil;

  @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
  public List<Usuario> getUsuarios(){
     return usuarioDao.getUsuarios();

  }

  @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
  public void registrarUsuario(@RequestBody Usuario usuario) {
    usuarioDao.registrar(usuario);

  }
  @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
  public void eliminar(@PathVariable BigInteger id) {
    usuarioDao.eliminar(id);
  }
}

