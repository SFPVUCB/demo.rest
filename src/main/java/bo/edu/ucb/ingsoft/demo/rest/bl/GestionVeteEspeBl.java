package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.VeteEspeDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.VeteEspe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionVeteEspeBl
{
    @Autowired
    VeteEspeDao veteEspeDao;
    public VeteEspe findEspeById(Integer id_especialidad)
    {
        return veteEspeDao.findEspeById(id_especialidad);
    }

    public List<VeteEspe> findAllEspe(Integer id_especialidad) {
        return veteEspeDao.findAllVeteEspe(id_especialidad);
    }

    public List<VeteEspe> findAllEspe1() {

        return veteEspeDao.findAllVeteEspe1();
    }


}
