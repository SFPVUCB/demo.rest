package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionVeterinarioBl;
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

    @GetMapping (path = "/veterinario/{apellido}")
    public Veterinario findVeterinarioById(@PathVariable String apellido) {
        Veterinario veterinario = gestionVeterinarioBl.findVeterinarioById(apellido);
        if (veterinario != null) {
            return gestionVeterinarioBl.findVeterinarioById(apellido);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el veterinario con codigo:" + apellido );
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

}