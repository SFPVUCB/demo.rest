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

        return veterinarioDao.crearVeterinario(veterinario);
    }

    public Veterinario findVeterinarioByApellido(String apellido) {

        return veterinarioDao.findVeterianrioByApellido(apellido);
    }

    public List<Veterinario> findAllVeterinarios() {
        return veterinarioDao.findAllVeterinarios();
    }

}