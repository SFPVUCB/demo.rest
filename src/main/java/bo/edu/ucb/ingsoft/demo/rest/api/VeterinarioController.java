package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionVeterinarioBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class VeterinarioController
{

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionVeterinarioBl gestionVeterinarioBl;

    @GetMapping (path = "/veterinario1/{departamento}")
    public ResponseDto findVeterinarioByDepartamento(@PathVariable String departamento) {
        Veterinario veterinario = gestionVeterinarioBl.findVeterinarioByDepartamento(departamento);
        if (veterinario != null) {
            return new ResponseDto( true, veterinario, null);
        } else {
            return new ResponseDto( false, null, "No existe el veterinario con codigo:");
        }
    }


    @GetMapping (path = "/veterinario/{apellido}")
    public ResponseDto findVeterinarioByApellido(@PathVariable String apellido) {
        Veterinario veterinario = gestionVeterinarioBl.findVeterinarioByApellido(apellido);
        if (veterinario != null) {
            return new ResponseDto( true, veterinario, null);
        } else {
            return new ResponseDto( false, null, "No existe el veterinario con el apellido:");
        }
    }





    @GetMapping(path = "/veterinario")
    public List<Veterinario> findAllVeterinarios() {
        return gestionVeterinarioBl.findAllVeterinarios();
    }

    @PostMapping(path = "/veterinario")
    public Veterinario createVeterinario(@RequestBody Veterinario veterinario) {
        // Validar que los datos enviados son correctos.
        if (veterinario.getNombre() == null || veterinario.getNombre().trim().equals("")) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }

        if (veterinario.getApellido() == null || veterinario.getApellido().trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido debe ser obligatorio" );
        }

        return gestionVeterinarioBl.crearVeterinario(veterinario);
    }

    @GetMapping(path = "/veterinario2/{departamento}")
    public List<Veterinario> findAllVeterinariosDep(@PathVariable String departamento) {
        List<Veterinario> veterinario = gestionVeterinarioBl.findAllVeterinariosDep(departamento);
        return gestionVeterinarioBl.findAllVeterinariosDep(departamento);
    }

    @GetMapping(path = "/veterinario3/{apellido}")
    public List<Veterinario> findAllVeterinariosApellido(@PathVariable String apellido) {
        List<Veterinario> veterinario = gestionVeterinarioBl.findAllVeterinariosDep(apellido);
        return gestionVeterinarioBl.findAllVeterinariosApellidos(apellido);
    }

}