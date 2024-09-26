package model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CursaId implements Serializable {

    private Long dniEstudiante;
    private Long idCarrera;

    public CursaId() {
        super();
    }
    public CursaId(Long dniEstudiante, Long idCarrera) {
        this.dniEstudiante = dniEstudiante;
        this.idCarrera = idCarrera;
    }

    public Long getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(Long dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
}
