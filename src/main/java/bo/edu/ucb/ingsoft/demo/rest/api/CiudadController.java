package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionCiudadBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class CiudadController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionCiudadBl gestionCiudadBl;

    @GetMapping(path = "/ciudad/{id_ciudad}")
    public ResponseDto findCiudadById(@PathVariable Integer id_ciudad) {
        Ciudad ciudad = gestionCiudadBl.findCiudadById(id_ciudad);
        if (ciudad != null) {
            return new ResponseDto( true, ciudad, null);
        } else {
            return new ResponseDto( false, null, "No existe el veterinario con codigo:");
        }
    }

    @GetMapping(path = "/ciudad2/{id_ciudad}")
    public List<Ciudad> findAllCiudades(@PathVariable Integer id_ciudad) {
        List<Ciudad> ciudad = gestionCiudadBl.findAllCiudades(id_ciudad);
        return gestionCiudadBl.findAllCiudades(id_ciudad);
    }
    @GetMapping(path = "/ciudad1")
    public List<Ciudad> findAllCiudad() {
        return gestionCiudadBl.findAllCiudad();
    }


}

