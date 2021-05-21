package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalificacionDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Calificacion crearCalificacion (Calificacion calificacion) {
        calificacion.setId_calificacion(sequenceDao.getPrimaryKeyForTable("calificacion"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO calificacion VALUES (?,?,?,?,?) ");
            stmt.setInt(1, calificacion.getCalificacion());
            stmt.setInt(2, calificacion.getId_usuario());
            stmt.setInt(3, calificacion.getId_consulta());
            stmt.setDate(4, (Date) calificacion.getFecha());
            stmt.setInt(5, calificacion.getCalificacion());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }
        return calificacion;
    }

    public Calificacion findCalificacionById(Integer id_calificacion) {
        Calificacion result = new Calificacion();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM calificacion WHERE id_calificacion = ? ")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_calificacion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_calificacion(rs.getInt("id_calificacion"));
                result.setId_usuario(rs.getInt("id_usuario"));
                result.setId_consulta(rs.getInt("id_consulta"));
                result.setFecha(rs.getDate("fecha"));
                result.setCalificacion(rs.getInt("calificacion"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Calificacion> findAllCalificaciones() {
        List<Calificacion> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM calificacion");
            while (rs.next()) {
                Calificacion calificacion = new Calificacion();
                calificacion.setId_calificacion(rs.getInt("id_calificacion"));
                calificacion.setId_usuario(rs.getInt("id_usuario"));
                calificacion.setId_consulta(rs.getInt("id_consulta"));
                calificacion.setFecha(rs.getDate("fecha"));
                calificacion.setCalificacion(rs.getInt("calificacion"));
                result.add(calificacion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}