package com.cursoJava.curso.Controllers;
import com.cursoJava.curso.Models.Equipo;
import com.cursoJava.curso.dao.EquipoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class EquipoController {

    @Autowired
    private EquipoDao equipoDao;

    @RequestMapping(value ="api/Equipo", method = RequestMethod.GET)
    public List<Equipo> getEquipos() {
        return equipoDao.getEquipos();
    }

    @RequestMapping(value ="api/Equipo", method = RequestMethod.POST)
    public void agregarEquipo(@RequestBody Equipo equipo) {
        equipoDao.guardar(equipo);
    }

    @RequestMapping(value = "api/Equipo/{sn}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable BigInteger sn) {
        equipoDao.borrar(sn);
    }

}

