package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.CalificacionDao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Calificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionCalificacionBl {

    @Autowired
    CalificacionDao calificacionDao;

    public Calificacion crearCalificacion(Calificacion calificacion) { return calificacionDao.crearCalificacion(calificacion);
    }

    public Calificacion findCalificacionById(Integer id_calificacion) { return calificacionDao.findCalificacionById(id_calificacion);
    }

    public List<Calificacion> findAllCalificaciones() { return calificacionDao.findAllCalificaciones();
    }

}