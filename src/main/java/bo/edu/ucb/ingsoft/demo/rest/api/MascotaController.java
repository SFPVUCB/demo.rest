package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionHorarioBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionMascotaBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Mascota;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;

@RestController
public class MascotaController {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionMascotaBl gestionMascotaBl;

    @GetMapping(path = "/mascota/{id_mascota}")
    public ResponseDto findMascotaById(@PathVariable Integer id_mascota) {
        Mascota mascota = gestionMascotaBl.findMascotaById(id_mascota);
        if (mascota != null) {
            return new ResponseDto( true, mascota, null);
        } else {
            return new ResponseDto( false, null, "No existe la mascota con codigo:");
        }
    }

    @GetMapping(path = "/mascota")
    public ResponseDto findAllMascotas() {
        return new ResponseDto( true, gestionMascotaBl.findAllMascotas(), null);
    }

    @PostMapping(path = "/mascota")
    public Mascota createMascota(@RequestBody Mascota mascota) {
        if (mascota.getId_especie() == null || mascota.getId_especie().equals("") || mascota.getId_dueño()<=0) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (mascota.getId_raza() == null || mascota.getId_raza().equals("") || mascota.getId_dueño()<=0) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (mascota.getId_imagen() == null || mascota.getId_imagen().equals("") || mascota.getId_dueño()<=0) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (mascota.getId_dueño() == null || mascota.getId_dueño().equals("") || mascota.getId_dueño()<=0) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (mascota.getNombre_mascota() == null || mascota.getNombre_mascota().trim().equals("")) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (mascota.getTamaño() == null || mascota.getTamaño().trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tamaño es obligatirio" );
        }
        if (mascota.getColor() == null || mascota.getColor().trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tamaño es obligatirio" );
        }
        if (mascota.getSexo() == null || mascota.getSexo().trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tamaño es obligatirio" );
        }
        if (mascota.getFecha_registro() == null || mascota.getFecha_registro().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tamaño es obligatirio" );
        }

        return gestionMascotaBl.crearMascota(mascota);
    }

}