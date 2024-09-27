package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    private Long id_carrera;
    @Column
    private String nombre_carrera;
    @OneToMany(mappedBy = "carrera")
    List<Cursa> estudiantesMatriculados;

    public Carrera() {
        super();
    }

    public Carrera(Long id_carrera, String nombre_carrera) {
        super();
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
        this.estudiantesMatriculados = new ArrayList<Cursa>();
    }

    public List<Cursa> getEstudiantesMatriculados() {
        return estudiantesMatriculados;
    }

    public void addEstudiantesMatriculados(Cursa estudianteMatriculado) {
        this.estudiantesMatriculados.add(estudianteMatriculado);
    }

    public Long getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Long id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id_carrera=" + id_carrera +
                ", nombre_carrera='" + nombre_carrera + '\'' +
                ", estudiantes=" + estudiantesMatriculados +
                '}';
    }
}
