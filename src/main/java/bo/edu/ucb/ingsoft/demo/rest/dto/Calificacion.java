package bo.edu.ucb.ingsoft.demo.rest.dto;

import java.util.Date;

public class Calificacion
{
    private Integer id_calificacion;
    private Integer id_usuario;
    private Integer id_consulta;
    private Date Fecha;
    private int calificacion;
    //constructor
    public Calificacion() { }
    //getters and setters

    public Integer getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Integer id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Integer id_consulta) {
        this.id_consulta = id_consulta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
