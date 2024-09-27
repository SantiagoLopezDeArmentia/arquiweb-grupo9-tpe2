package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante implements Serializable {

    @Id
    private Long dni_estudiante;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private Long nro_libreta;
    @Column
    private String genero;
    @Column
    private String ciudad;
    @OneToMany(mappedBy = "estudiante", fetch= FetchType.LAZY)
    private List<Cursa> cursadas;

    public Estudiante() {
        super();
    }

    public Estudiante(Long dni_estudiante, String nombre,
                      String apellido, int edad, Long nro_libreta,
                      String genero, String ciudad) {
        super();
        this.dni_estudiante = dni_estudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nro_libreta = nro_libreta;
        this.genero = genero;
        this.ciudad = ciudad;
        this.cursadas = new ArrayList<Cursa>();
    }

    public Long getDni_estudiante() {
        return dni_estudiante;
    }

    public void setDni_estudiante(Long dni_estudiante) {
        this.dni_estudiante = dni_estudiante;
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

    public List<Cursa> getCursadas() {
        return cursadas;
    }

    public void addCarrera(Cursa carrera) {
        this.cursadas.add(carrera);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getNro_libreta() {
        return nro_libreta;
    }

    public void setNro_libreta(Long nro_libreta) {
        this.nro_libreta = nro_libreta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni_estudiante=" + dni_estudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nro_libreta=" + nro_libreta +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", cursadas=" + cursadas +
                '}';
    }
}
