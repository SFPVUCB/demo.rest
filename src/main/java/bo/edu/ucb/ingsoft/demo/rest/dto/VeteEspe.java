package bo.edu.ucb.ingsoft.demo.rest.dto;

public class VeteEspe
{
    private Integer id_veterinarioEspe;
    private Integer id_veterinario;
    private Integer id_especialidad;

    public VeteEspe() { }

    public Integer getId_veterinarioEspe() {
        return id_veterinarioEspe;
    }

    public void setId_veterinarioEspe(Integer id_veterinarioEspe) {
        this.id_veterinarioEspe = id_veterinarioEspe;
    }

    public Integer getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Integer id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public Integer getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Integer id_especialidad) {
        this.id_especialidad = id_especialidad;
    }
}

