package model.dto.converter;

import model.Entities.Estudiante;
import model.dto.EstudianteDTO;

public class ConverterEstudianteDTO extends ConverterDTO<Estudiante, EstudianteDTO> {
    public Estudiante fromDTO(EstudianteDTO d) {
        if(d == null)
            return null;

        return new Estudiante(d.getDniEstudiante(), d.getNombre(), d.getApellido(), d.getEdad(), d.getNroLibreta(), d.getGenero(), d.getCiudad());
    }

    public EstudianteDTO fromEntity(Estudiante e) {
        if(e == null)
            return null;

        return new EstudianteDTO(e.getDniEstudiante(), e.getNombre(), e.getApellido(), e.getEdad(), e.getNroLibreta(), e.getGenero(), e.getCiudad());
    }
}
