package model.dto;

import java.util.LinkedList;
import java.util.List;

public class CarreraInscriptosDTO {
    private String nombre;
    private int cantInscriptos;
    private List<EstudianteDTO> estudiantes;

    public CarreraInscriptosDTO(String nombre, int cantInscriptos) {
        this.nombre = nombre;
        this.cantInscriptos = cantInscriptos;
        this.estudiantes = new LinkedList<>();
    }
}
