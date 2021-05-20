package bo.edu.ucb.ingsoft.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EspecieController {

    @Autowired
    public DataSource dataSource;

    @GetMapping(path = "/especie/{especieId}")
    public Especie findEspecieById(@PathVariable Integer especieId) {
        Especie result = new Especie();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_especie, especie FROM especie" +
                    "  WHERE id_especie = " + especieId);  //FIXME SQL INJECTION !!!!!
            if (rs.next()) {
                result.especieId = rs.getInt("id_especie");
                result.especie = rs.getString("especie");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "/especie")

    public List<Especie> findAllEspecies() {
        List<Especie> result = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_especie, especie FROM especie");
            while (rs.next()) {
                Especie especie = new Especie();
                especie.especieId = rs.getInt("id_especie");
                especie.especie = rs.getString("especie");

                result.add(especie);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @PostMapping(path = "/especie")
    public Especie createEspecie(@RequestBody Especie especie) {
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO especie VALUES ("
                     + especie.especieId + ", '"+ especie.especie + "')");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return especie;

        // Completar los metodos UPDATE y DELETE

    }
    @DeleteMapping(path = "/especie/{especieId}")
    public void DeleteById(@PathVariable Integer especieId) {
        try
        {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM especie" +
                    "  WHERE id_especie = " + especieId);  //FIXME SQL INJECTION !!!!!

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    //

    @PutMapping(path = "/especie/{especieId}")
    public Especie updateEspecie(@RequestBody Especie especie,@PathVariable int especieId)
    {
        try
        {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement pst;
            pst = conn.prepareStatement("UPDATE  especie SET especie=? WHERE id_especie = "+especieId);
            pst.setString(1, especie.especie);
            pst.executeUpdate();
            pst.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        especie.especieId=especieId;
        return (especie);

    }

}