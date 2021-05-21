package bo.edu.ucb.ingsoft.demo.rest.dao;


import bo.edu.ucb.ingsoft.demo.rest.dto.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Mascota crearMascota (Mascota mascota) {
        mascota.setId_mascota(sequenceDao.getPrimaryKeyForTable("mascota"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO mascota VALUES (?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, mascota.getId_mascota());
            stmt.setInt(2, mascota.getId_especie());
            stmt.setInt(3, mascota.getId_raza());
            stmt.setInt(4, mascota.getId_imagen());
            stmt.setInt(5, mascota.getId_dueño());
            stmt.setString(6, mascota.getNombre_mascota());
            stmt.setString(7, mascota.getTamaño());
            stmt.setString(8, mascota.getSexo());
            stmt.setDate(9, (Date) mascota.getFecha_registro());
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
        return mascota;
    }

    public Mascota findMascotaById(Integer id_mascota) {
        Mascota result = new Mascota();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM mascota WHERE id_mascota = ? ")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_mascota);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_mascota(rs.getInt("id_mascota"));
                result.setId_especie(rs.getInt("id_especie"));
                result.setId_raza(rs.getInt("id_raza"));
                result.setId_imagen(rs.getInt("id_imagen"));
                result.setId_dueño(rs.getInt("id_dueño"));
                result.setNombre_mascota(rs.getString("nombre_mascota"));
                result.setTamaño(rs.getString("tamaño"));
                result.setColor(rs.getString("color"));
                result.setSexo(rs.getString("sexo"));
                result.setFecha_registro(rs.getDate("fecha_registro"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Mascota> findAllMascota() {
        List<Mascota> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM mascota");
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setId_mascota(rs.getInt("id_mascota"));
                mascota.setId_especie(rs.getInt("id_especie"));
                mascota.setId_raza(rs.getInt("id_raza"));
                mascota.setId_imagen(rs.getInt("id_imagen"));
                mascota.setId_dueño(rs.getInt("id_dueño"));
                mascota.setNombre_mascota(rs.getString("nombre_mascota"));
                mascota.setTamaño(rs.getString("tamaño"));
                mascota.setColor(rs.getString("color"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setFecha_registro(rs.getDate("fecha_registro"));
                result.add(mascota);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}