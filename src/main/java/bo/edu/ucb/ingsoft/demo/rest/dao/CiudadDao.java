package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Ciudad;
import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
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
public class CiudadDao
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Ciudad findCiudadById(Integer id_ciudad) {
        Ciudad result = new Ciudad();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM ciudad WHERE ciudad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_ciudad);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_ciudad(rs.getInt("ciudad_id"));
                result.setNombre(rs.getString("nombre"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Ciudad> findAllCiudades(Integer id_ciudad) {
        List<Ciudad> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM ciudad WHERE ciudad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_ciudad);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Ciudad ciudad = new Ciudad();
                ciudad.setId_ciudad(rs.getInt("ciudad_id"));
                ciudad.setNombre(rs.getString("nombre"));

                result1.add(ciudad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;

    }
    public List<Ciudad> findAllCiudad() {
        List<Ciudad> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM ciudad");
            while (rs.next())
            {
                Ciudad ciudad = new Ciudad();
                ciudad.setId_ciudad(rs.getInt("ciudad_id"));
                ciudad.setNombre(rs.getString("nombre"));
                result.add(ciudad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

}
