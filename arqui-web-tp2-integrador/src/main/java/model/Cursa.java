package model;

import javax.persistence.*;

@Entity
public class Cursa {
    @EmbeddedId
    private CursaId id;
    @ManyToOne
    @MapsId ("dniEstudiante")
    @JoinColumn(name = "dniEstudiante")
    private Estudiante estudiante;
    @ManyToOne
    @MapsId ("idCarrera")
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    @Column
    private int antiguedad;
    @Column
    private boolean es_graduado;

    public Cursa() { super(); }

    public Cursa(CursaId id, Estudiante estudiante, Carrera carrera, int antiguedad, boolean es_graduado) {
        super();
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.es_graduado = es_graduado;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                //", estudiante=" + estudiante +
                //", carrera=" + carrera +
                ", antiguedad=" + antiguedad +
                ", es_graduado=" + es_graduado +
                '}';
    }
}
