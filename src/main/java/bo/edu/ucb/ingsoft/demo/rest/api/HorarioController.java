package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionHorarioBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionVeterinarioBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionHorarioBl gestionHorarioBl;

    @GetMapping(path = "/horario/{id_horario}")
    public ResponseDto findHorarioById(@PathVariable Integer id_horario) {
        Horario horario = gestionHorarioBl.findHorarioById(id_horario);
        if (horario != null) {
            return new ResponseDto( true, horario, null);
        } else {
            return new ResponseDto( false, null, "No existe el horario con codigo:");
        }
    }

    @GetMapping(path = "/horario")
    public ResponseDto findAllHorarios() {
        return new ResponseDto( true, gestionHorarioBl.findAllHorarios(), null);
    }

    @PostMapping(path = "/horario")
    public ResponseDto createHorario(@RequestBody Horario horario) {
        // Validar que los datos enviados son correctos.


        return new ResponseDto(true, gestionHorarioBl.crearHorario(horario), null);
    }

    @GetMapping(path = "/horario1/{id_veterinario}")
    public List<Horario> findAllHorarioId(@PathVariable Integer id_veterinario) {
        List<Horario> horario = gestionHorarioBl.findAllHorarioId(id_veterinario);
        return gestionHorarioBl.findAllHorarioId(id_veterinario);
    }

}