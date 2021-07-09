package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.CiudadDao;
import bo.edu.ucb.ingsoft.demo.rest.dao.EspecialidadDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionEspecialidadBl
{
    @Autowired
    EspecialidadDao especialidadDao;

    public List<Especialidad> findAllEspecialidades() {
        return especialidadDao.findAllEspecialidades();
    }

}
