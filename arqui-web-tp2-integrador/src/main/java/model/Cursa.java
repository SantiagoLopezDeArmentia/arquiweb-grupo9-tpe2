package model;

import javax.persistence.*;

@Entity
public class Cursa {
    @EmbeddedId
    private CursaId id;
    @ManyToOne
    @MapsId ("dniEstudiante")
    private Estudiante estudiante;
    @ManyToOne
    @MapsId ("idCarrera")
    private Carrera carrera;

    @Column
    private int antiguedad;
    @Column
    private boolean es_graduado;
}
