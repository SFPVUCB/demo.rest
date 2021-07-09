package bo.edu.ucb.ingsoft.demo.rest.dto;

public class Ciudad
{
    private Integer id_ciudad;
    private String nombre;

    public Ciudad() { }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
