package bo.edu.ucb.ingsoft.demo.rest.dto;

import java.util.Date;

public class Mascota
{
    private Integer id_mascota;
    private Integer id_especie;
    private Integer id_raza;
    private Integer id_imagen;
    private Integer id_dueño;
    private String nombre_mascota;
    private String tamaño;
    private String color;
    private String sexo;
    private Date fecha_registro;
    //constructor
    public Mascota() {}
    //getters and setters

    public Integer getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }

    public Integer getId_especie() {
        return id_especie;
    }

    public void setId_especie(Integer id_especie) {
        this.id_especie = id_especie;
    }

    public Integer getId_raza() {
        return id_raza;
    }

    public void setId_raza(Integer id_raza) {
        this.id_raza = id_raza;
    }

    public Integer getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Integer id_imagen) {
        this.id_imagen = id_imagen;
    }

    public Integer getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(Integer id_dueño) {
        this.id_dueño = id_dueño;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}

