package model.dto.converter;

import model.Entities.Carrera;
import model.dto.CarreraDTO;

public class ConverterCarreraDTO extends ConverterDTO<Carrera, CarreraDTO> {
    public Carrera fromDTO(CarreraDTO d) {
        if(d == null)
            return null;

        return new Carrera(d.getIdCarrera(), d.getNombreCarrera());
    }

    public CarreraDTO fromEntity(Carrera e) {
        if(e == null)
            return null;

        return new CarreraDTO(e.getIdCarrera(), e.getNombreCarrera());
    }
}
