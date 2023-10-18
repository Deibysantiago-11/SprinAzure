package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
@Transactional
public class EquipoDaoImp implements EquipoDao{

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public List<Equipo>getEquipos() {
            String query = ("FROM Equipo");
            return entityManager.createQuery(query,Equipo.class).getResultList();
        }

    @Override
    public void borrar(BigInteger sn) {
        Equipo equipo = entityManager.find(Equipo.class,sn);
        entityManager.remove(equipo);
    }
    @Override
    public void guardar(Equipo equipo) {entityManager.merge(equipo);
    }
}




