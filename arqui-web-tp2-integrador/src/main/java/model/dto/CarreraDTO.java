package model.dto;

public class CarreraDTO {
    private Long idCarrera;
    private String nombreCarrera;

    public CarreraDTO(Long idCarrera, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
}
