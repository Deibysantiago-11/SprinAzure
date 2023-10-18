package com.cursoJava.curso.dao;
import com.cursoJava.curso.Models.Admin;
import com.cursoJava.curso.Models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class AdminDaoImp implements AdminDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
   public Admin verificarCredenciales(Admin admin) {
        String query = "FROM Admin WHERE id = :id AND correo = :correo ";
        List<Admin> lista = entityManager.createQuery(query)
                .setParameter("id", admin.getId())
                .setParameter("correo", admin.getCorreo())
                .getResultList();


        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();


        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, admin.getPassword())) {

    return lista.get(0);
        }
    return null;

    }

    @Override
    public void Guardar(Admin admin) {
            entityManager.merge(admin);
    }


}

