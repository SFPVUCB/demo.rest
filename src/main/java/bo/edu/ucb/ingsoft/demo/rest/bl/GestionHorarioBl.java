package bo.edu.ucb.ingsoft.demo.rest.bl;


import bo.edu.ucb.ingsoft.demo.rest.dao.HorarioDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GestionHorarioBl {

    @Autowired
    HorarioDao horarioDao;

    public Horario crearHorario(Horario horario) {
        return horarioDao.crearHorario(horario);
    }

    public Horario findHorarioById(Integer id_horario) {
        return horarioDao.findHorarioById(id_horario);
    }

    public List<Horario> findAllHorarios() {
        return horarioDao.findAllHorarios();
    }

    public List<Horario> findAllHorarioId(Integer id_veterinario) {
        return horarioDao.findAllHorarioId(id_veterinario);
    }

}