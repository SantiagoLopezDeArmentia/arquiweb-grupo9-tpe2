package repositories;

import model.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    public List<Estudiante> findAllByOrder(String columnName);
    public Estudiante findByNroLibreta(Long nro_libreta);
    public List<Estudiante> findAllByGenero(String genero);
}
