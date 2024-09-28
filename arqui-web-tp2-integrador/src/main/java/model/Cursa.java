package model;

import javax.persistence.*;

@Entity
public class Cursa {
    @EmbeddedId
    private CursaId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId ("dniEstudiante")
    @JoinColumn(name = "dni_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId ("idCarrera")
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera carrera;

    @Column
    private int antiguedad;

    @Column(name = "es_graduado")
    private boolean esGraduado;

    public Cursa() { super(); }

    public Cursa(CursaId id, Estudiante estudiante, Carrera carrera, int antiguedad, boolean esGraduado) {
        super();
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.esGraduado = esGraduado;
    }

    public CursaId getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public boolean isEsGraduado() {
        return esGraduado;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                //", estudiante=" + estudiante +
                //", carrera=" + carrera +
                ", antiguedad=" + antiguedad +
                ", es_graduado=" + esGraduado +
                '}';
    }
}
