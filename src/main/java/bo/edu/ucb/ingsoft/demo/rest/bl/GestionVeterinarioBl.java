package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.VeterinarioDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionVeterinarioBl
{

    @Autowired
    VeterinarioDao veterinarioDao;

    public Veterinario crearVeterinario(Veterinario veterinario) {
        // Computamos el nuemero de seguro social, conformado por los tres primeros caracteres
        // del nombre mas los tres primeros del apelliod
        return veterinarioDao.crearVeterinario(veterinario);
    }

    public Veterinario findVeterinarioById(String apellido) {

        return veterinarioDao.findVeterianrioById(apellido);
    }

    public List<Veterinario> findAllVeterinarios() {
        return veterinarioDao.findAllVeterinarios();
    }

}