package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.HorarioDao;
import bo.edu.ucb.ingsoft.demo.rest.dao.MascotaDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionMascotaBl {

    @Autowired
    MascotaDao mascotaDao;

    public Mascota crearMascota(Mascota mascota) {
        return mascotaDao.crearMascota(mascota);
    }

    public Mascota findMascotaById(Integer id_mascota) {
        return mascotaDao.findMascotaById(id_mascota);
    }

    public List<Mascota> findAllMascotas() {
        return mascotaDao.findAllMascota();
    }

}