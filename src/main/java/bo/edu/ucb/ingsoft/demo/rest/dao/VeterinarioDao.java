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
        veterinario.setId_veterinario(sequenceDao.getPrimaryKeyForTable("veterinario"));
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO veterinario VALUES (?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, veterinario.getId_veterinario());
            stmt.setInt(2, veterinario.getId_usuario());
            stmt.setInt(3, veterinario.getId_veterinaria());
            stmt.setInt(4, veterinario.getId_imagen());
            stmt.setInt(5, veterinario.getId_ciudad());
            stmt.setString(6, veterinario.getNombre());
            stmt.setString(7, veterinario.getApellido());
            stmt.setString(8, veterinario.getEmail());
            stmt.setString(9, veterinario.getLugar_formacion());
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
        return veterinario;
    }

    public Veterinario findVeterianrioById(Integer id_veterinario) {
        Veterinario result = new Veterinario();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario WHERE veterinario_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_veterinario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_veterinario(rs.getInt("veterinario_id"));
                result.setId_usuario(rs.getInt("usuario_id"));
                result.setId_veterinaria(rs.getInt("veterinaria_id"));
                result.setId_imagen(rs.getInt("imagen_id"));
                result.setId_ciudad(rs.getInt("ciudad_id"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setEmail(rs.getString("email"));
                result.setLugar_formacion(rs.getString("lugar_formacion"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    /*
    public Veterinario findVeterinarioByApellido(String apellido) {
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

     */

    public List<Veterinario> findAllVeterinarios() {
        List<Veterinario> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM veterinario");
            while (rs.next())
            {
                Veterinario veterinario = new Veterinario();
                veterinario.setId_veterinario(rs.getInt("veterinario_id"));
                veterinario.setId_usuario(rs.getInt("usuario_id"));
                veterinario.setId_veterinaria(rs.getInt("veterinaria_id"));
                veterinario.setId_imagen(rs.getInt("imagen_id"));
                veterinario.setId_ciudad(rs.getInt("ciudad_id"));
                veterinario.setNombre(rs.getString("nombre"));
                veterinario.setApellido(rs.getString("apellido"));
                veterinario.setEmail(rs.getString("email"));
                veterinario.setLugar_formacion(rs.getString("lugar_formacion"));
                result.add(veterinario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

    public List<Veterinario> findAllVeterinariosDep(Integer id_ciudad) {
        List<Veterinario> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario WHERE ciudad_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, id_ciudad);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Veterinario veterinario = new Veterinario();
                veterinario.setId_veterinario(rs.getInt("veterinario_id"));
                veterinario.setId_usuario(rs.getInt("usuario_id"));
                veterinario.setId_veterinaria(rs.getInt("veterinaria_id"));
                veterinario.setId_imagen(rs.getInt("imagen_id"));
                veterinario.setId_ciudad(rs.getInt("ciudad_id"));
                veterinario.setNombre(rs.getString("nombre"));
                veterinario.setApellido(rs.getString("apellido"));
                veterinario.setEmail(rs.getString("email"));
                veterinario.setLugar_formacion(rs.getString("lugar_formacion"));
                result1.add(veterinario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;
        //apellidos
    }
    public List<Veterinario> findAllVeterinariosApellidos(String apellido) {
        List<Veterinario> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM veterinario WHERE apellido = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setString(1, apellido);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Veterinario veterinario = new Veterinario();
                veterinario.setId_veterinario(rs.getInt("veterinario_id"));
                veterinario.setId_usuario(rs.getInt("usuario_id"));
                veterinario.setId_veterinaria(rs.getInt("veterinaria_id"));
                veterinario.setId_imagen(rs.getInt("imagen_id"));
                veterinario.setId_ciudad(rs.getInt("ciudad_id"));
                veterinario.setNombre(rs.getString("nombre"));
                veterinario.setApellido(rs.getString("apellido"));
                veterinario.setEmail(rs.getString("email"));
                veterinario.setLugar_formacion(rs.getString("lugar_formacion"));
                result1.add(veterinario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;
        //apellidos
    }






}