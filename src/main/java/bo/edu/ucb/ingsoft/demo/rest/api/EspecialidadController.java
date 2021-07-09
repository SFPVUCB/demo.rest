package bo.edu.ucb.ingsoft.demo.rest.api;


import bo.edu.ucb.ingsoft.demo.rest.bl.GestionEspecialidadBl;

import bo.edu.ucb.ingsoft.demo.rest.dto.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import javax.sql.DataSource;
import java.util.List;

public class EspecialidadController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionEspecialidadBl gestionEspecialidadBl;

    @GetMapping(path = "/especialidad")
    public List<Especialidad> findAllEspecialidades() {

        return gestionEspecialidadBl.findAllEspecialidades();
    }


}
