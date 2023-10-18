package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario>getUsuarios() {
        String query = ("FROM Usuario");
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }
    @Override
    public void eliminar(BigInteger id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
    entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
}


