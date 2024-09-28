package model.dto.converter;

import model.Carrera;
import model.dto.CarreraInscriptosDTO;

public class ConverterCarreraInscriptosDTO extends ConverterDTO<Carrera, CarreraInscriptosDTO> {
    @Override
    public CarreraInscriptosDTO fromEntity(Carrera e) {
        if(e == null)
            return null;

        return null;
    }

    @Override
    public Carrera fromDTO(CarreraInscriptosDTO d) {
        return null;
    }
}
