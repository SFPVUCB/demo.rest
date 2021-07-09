package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadDao
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Especialidad findEspecialidadById(Integer id_especialidad) {
        Especialidad result = new Especialidad();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM especialidad WHERE especialidad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_especialidad);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_especialidad(rs.getInt("especialidad_id"));
                result.setEspecialidad(rs.getString("especialidad"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public List<Especialidad> findAllEspecialidades() {
        List<Especialidad> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM especialidad");
            while (rs.next())
            {
                Especialidad especialidad = new Especialidad();
                especialidad.setId_especialidad(rs.getInt("id_especialidad"));
                especialidad.setEspecialidad(rs.getString("especialidad"));
                result.add(especialidad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }
}
