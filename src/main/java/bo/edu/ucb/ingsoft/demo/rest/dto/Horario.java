package bo.edu.ucb.ingsoft.demo.rest.dto;

import java.sql.Time;


public class Horario
{
    private Integer id_horario;
    private Integer id_veterinario;
    private String dia;
    private Time desde_hrs;
    private Time hasta_hrs;
    //constructor
    public Horario() { }
    //getters and setters

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    public Integer getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Integer id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getDesde_hrs() {
        return desde_hrs;
    }

    public void setDesde_hrs(Time desde_hrs) {
        this.desde_hrs = desde_hrs;
    }

    public Time getHasta_hrs() {
        return hasta_hrs;
    }

    public void setHasta_hrs(Time hasta_hrs) {
        this.hasta_hrs = hasta_hrs;
    }
}
