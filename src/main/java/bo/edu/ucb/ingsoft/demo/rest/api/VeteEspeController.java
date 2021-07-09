package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionCiudadBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionVeteEspeBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.VeteEspe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class VeteEspeController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionVeteEspeBl gestionVeteEspeBl;

    @GetMapping(path = "/veteespe/{id_especialidad}")
    public ResponseDto findVeteEspeById(@PathVariable Integer id_especialidad) {
        VeteEspe veteEspe = gestionVeteEspeBl.findEspeById(id_especialidad);
        if (veteEspe != null) {
            return new ResponseDto( true, veteEspe, null);
        } else {
            return new ResponseDto( false, null, "No existe el veterinario con codigo:");
        }
    }
    @GetMapping(path = "/veteespe1/{id_ciudad}")
    public List<VeteEspe> findAllVeteEspe(@PathVariable Integer id_ciudad) {
        List<VeteEspe> veteespe = gestionVeteEspeBl.findAllEspe(id_ciudad);
        return gestionVeteEspeBl.findAllEspe(id_ciudad);
    }
    @GetMapping(path = "/veteespe2")
    public List<VeteEspe> findAllCiudad() {

        return gestionVeteEspeBl.findAllEspe1();
    }
}
