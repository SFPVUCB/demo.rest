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


    public Veterinario findVeterinarioById(Integer id_veterinario)
    {
        return veterinarioDao.findVeterianrioById(id_veterinario);
    }
    /*
    public Veterinario findVeterinarioByApellido(String apellido)
    {
        return veterinarioDao.findVeterinarioByApellido(apellido);
    }

     */


    public List<Veterinario> findAllVeterinarios() {
        return veterinarioDao.findAllVeterinarios();
    }

    public List<Veterinario> findAllVeterinariosDep(Integer id_ciudad) {
        return veterinarioDao.findAllVeterinariosDep(id_ciudad);
    }
    public List<Veterinario> findAllVeterinariosApellidos(String apellido) {
        return veterinarioDao.findAllVeterinariosApellidos(apellido);
    }




}