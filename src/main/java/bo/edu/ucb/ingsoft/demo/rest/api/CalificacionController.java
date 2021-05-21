package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionCalificacionBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionHorarioBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.Calificacion;
import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class CalificacionController {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionCalificacionBl gestionCalificacionBl;

    @GetMapping(path = "/calificacion/{id_calificacion}")
    public ResponseDto findCalificacionById(@PathVariable Integer id_calificacion) {
        Calificacion calificacion = gestionCalificacionBl.findCalificacionById(id_calificacion);
        if (calificacion != null) {
            return new ResponseDto( true, calificacion, null);
        } else {
            return new ResponseDto( false, null, "No existe la calificacion con codigo:");
        }
    }

    @GetMapping(path = "/calificacion")
    public ResponseDto findAllCalificaciones() {
        return new ResponseDto( true, gestionCalificacionBl.findAllCalificaciones(), null);
    }

    @PostMapping(path = "/calificacion")
    public ResponseDto createCalificacion(@RequestBody Calificacion calificacion) {
        // Validar que los datos enviados son correctos.


        return new ResponseDto(true, gestionCalificacionBl.crearCalificacion(calificacion), null);
    }

}