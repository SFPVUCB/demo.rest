package bo.edu.ucb.ingsoft.demo.rest.dao;


import bo.edu.ucb.ingsoft.demo.rest.dto.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Horario crearHorario (Horario horario) {
        horario.setId_horario(sequenceDao.getPrimaryKeyForTable("horario"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO horario VALUES (?,?,?,?,?) ");
            stmt.setInt(1, horario.getId_horario());
            stmt.setInt(2, horario.getId_veterinario());
            stmt.setString(3, horario.getDia());
            stmt.setTime(4, horario.getDesde_hrs());
            stmt.setTime(5, horario.getHasta_hrs());
            stmt.executeUpdate();
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
        return horario;
    }

    public Horario findHorarioById(Integer id_horario) {
        Horario result = new Horario();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM horario WHERE id_horario = ? ")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_horario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_veterinario(rs.getInt("id_horario"));
                result.setId_veterinario(rs.getInt("id_veterinario"));
                result.setDia(rs.getString("dia"));
                result.setDesde_hrs(rs.getTime("desde_hrs"));
                result.setHasta_hrs(rs.getTime("hasta_hrs"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Horario> findAllHorarios() {
        List<Horario> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM horario");
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId_horario(rs.getInt("id_horario"));
                horario.setId_veterinario(rs.getInt("id_veterinario"));
                horario.setDia(rs.getString("dia"));
                horario.setDesde_hrs(rs.getTime("desde_hrs"));
                horario.setHasta_hrs(rs.getTime("hasta_hrs"));
                result.add(horario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}