package com.cursoJava.curso.Controllers;
import com.cursoJava.curso.Models.Admin;
import com.cursoJava.curso.dao.AdminDao;
import com.cursoJava.curso.utils.JWTutil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private JWTutil jwTutil;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Admin admin) {

        Admin logueo = adminDao.verificarCredenciales(admin);
       if (logueo != null) {

           String token = jwTutil.create(String.valueOf(logueo.getId()), logueo.getCorreo());

            return token;
       }
       return "FAIL";
    }
    @RequestMapping(value = "api/login/admin", method = RequestMethod.POST)
    public void ActualizarPassword(@RequestBody Admin admin) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, admin.getPassword());
        admin.setPassword(hash);

    adminDao.Guardar(admin);

    }
}


