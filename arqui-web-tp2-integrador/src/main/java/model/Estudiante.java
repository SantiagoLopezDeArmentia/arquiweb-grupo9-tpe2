package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "estudiante")
    List<Cursa> carreras;

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
        this.carreras = new ArrayList<Cursa>();
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

    public List<Cursa> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Cursa> carreras) {
        this.carreras = carreras;
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
}
