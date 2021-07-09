package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.CiudadDao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;

import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionCiudadBl
{
    @Autowired
    CiudadDao ciudadDao;
    public Ciudad findCiudadById(Integer id_ciudad)
    {
        return ciudadDao.findCiudadById(id_ciudad);
    }

    public List<Ciudad> findAllCiudades(Integer id_ciudad) {
        return ciudadDao.findAllCiudades(id_ciudad);
    }

    public List<Ciudad> findAllCiudad() {
        return ciudadDao.findAllCiudad();
    }

}
