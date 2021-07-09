package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.VeteEspe;
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
public class VeteEspeDao
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public VeteEspe findEspeById (Integer id_especialidad) {
        VeteEspe result = new VeteEspe();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario_especialidad WHERE especialidad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_especialidad);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_veterinarioEspe(rs.getInt("veterinario_especialidad_id"));
                result.setId_veterinario(rs.getInt("veterinario_id"));
                result.setId_especialidad(rs.getInt("especialidad_id"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<VeteEspe> findAllVeteEspe(Integer id_especialidad) {
        List<VeteEspe> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario_especialidad WHERE especialidad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_especialidad);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                VeteEspe veteEspe = new VeteEspe();
                veteEspe.setId_veterinarioEspe(rs.getInt("veterinario_especialidad_id"));
                veteEspe.setId_veterinario(rs.getInt("veterinario_id"));
                veteEspe.setId_especialidad(rs.getInt("especialidad_id"));

                result1.add(veteEspe);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;

    }
    public List<VeteEspe> findAllVeteEspe1() {
        List<VeteEspe> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM veterinario_especialidad");
            while (rs.next())
            {
                VeteEspe veteEspe = new VeteEspe();
                veteEspe.setId_veterinarioEspe(rs.getInt("veterinario_especialidad_id"));
                veteEspe.setId_veterinario(rs.getInt("veterinario_id"));
                veteEspe.setId_veterinario(rs.getInt("especialidad_id"));
                result.add(veteEspe);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

}
