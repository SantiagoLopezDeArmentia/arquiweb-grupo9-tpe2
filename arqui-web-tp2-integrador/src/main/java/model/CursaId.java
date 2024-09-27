package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class CursaId implements Serializable {

    @Column
    private Long dniEstudiante;
    @Column
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
