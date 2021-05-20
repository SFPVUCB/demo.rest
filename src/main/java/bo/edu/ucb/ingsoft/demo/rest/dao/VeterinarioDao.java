package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeterinarioDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Veterinario crearVeterinario (Veterinario veterinario) {
        //veterinario.setId_veterinario(sequenceDao.getPrimaryKeyForTable("veterinario"));
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO veterinario(id_veterinario,id_usuario,id_veterinaria, nombre, apellido,email,departamento,lugar_formacion)" + "VALUES (?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, veterinario.getId_veterinario());
            stmt.setInt(2, veterinario.getId_usuario());
            stmt.setInt(3, veterinario.getId_veterinaria());
            stmt.setInt(4, veterinario.getId_imagen());
            stmt.setString(5, veterinario.getNombre());
            stmt.setString(6, veterinario.getApellido());
            stmt.setString(7, veterinario.getEmail());
            stmt.setString(8, veterinario.getDepartamento());
            stmt.setString(9, veterinario.getLugar_formacion());
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
        return veterinario;
    }
    public Veterinario findVeterianrioById(String apellido) {
        Veterinario result = new Veterinario();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario WHERE apellido = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setString(1, apellido);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_veterinario(rs.getInt("id_veterinario"));
                result.setId_usuario(rs.getInt("id_usuario"));
                result.setId_veterinaria(rs.getInt("id_veterinaria"));
                result.setId_imagen(rs.getInt("id_imagen"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setEmail(rs.getString("email"));
                result.setDepartamento(rs.getString("departamento"));
                result.setLugar_formacion(rs.getString("lugar_formacion"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Veterinario> findAllVeterinarios() {
        List<Veterinario> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM veterinario");
            while (rs.next()) {
                Veterinario veterinario = new Veterinario();
                veterinario.setId_veterinario(rs.getInt("id_veterinario"));
                veterinario.setId_usuario(rs.getInt("id_usuario"));
                veterinario.setId_veterinaria(rs.getInt("id_veterinaria"));
                veterinario.setId_imagen(rs.getInt("id_imagen"));
                veterinario.setNombre(rs.getString("nombre"));
                veterinario.setApellido(rs.getString("apellido"));
                veterinario.setEmail(rs.getString("email"));
                veterinario.setDepartamento(rs.getString("departamento"));
                veterinario.setLugar_formacion(rs.getString("lugar_formacion"));
                result.add(veterinario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}