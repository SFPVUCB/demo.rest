package bo.edu.ucb.ingsoft.demo.rest.dto;


public class Veterinario
{
    private Integer id_veterinario;
    private Integer id_usuario;
    private Integer id_veterinaria;
    private Integer id_imagen;
    private Integer id_ciudad;
    private String nombre;
    private String apellido;
    private String email;
    private String lugar_formacion;
    //constructor
    public Veterinario() { }
    //getters and setters
    public Integer getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Integer id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_veterinaria() {
        return id_veterinaria;
    }

    public void setId_veterinaria(Integer id_veterinaria) {
        this.id_veterinaria = id_veterinaria;
    }

    public Integer getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Integer id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_ciudad() {

        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getLugar_formacion() {
        return lugar_formacion;
    }

    public void setLugar_formacion(String lugar_formacion) {
        this.lugar_formacion = lugar_formacion;
    }
}
