import factories.MySqlFactory;
import model.Carrera;
import model.Cursa;
import model.CursaId;
import model.Estudiante;
import model.dto.CarreraDTO;
import model.dto.CarreraInscriptosDTO;
import model.dto.EstudianteDTO;
import model.dto.converter.ConverterCarreraDTO;
import model.dto.converter.ConverterEstudianteDTO;

import java.util.List;

public class Servicio {
    private final static MySqlFactory mySqlFactory = MySqlFactory.getInstance();

    public static void main(String[] args) {
        //Mapeadores
        ConverterEstudianteDTO converterEstudiante = new ConverterEstudianteDTO();
        ConverterCarreraDTO converterCarrera = new ConverterCarreraDTO();

        //Datos que se reciben
        EstudianteDTO e1 = new EstudianteDTO(45037195L, "Luciano", "Torres", 20, 100L, "M", "Tandil");
        EstudianteDTO e2 = new EstudianteDTO(45456789L, "Lucas", "Prueba", 34, 101L, "M", "Tandil");
        EstudianteDTO e3 = new EstudianteDTO(29421356L, "Maria", "Prueba", 54, 54L, "F", "Buenos Aires");
        CarreraDTO c1 = new CarreraDTO(1L, "TUDAI");
        CarreraDTO c2 = new CarreraDTO(2L, "Ingenieria de Computacion");

        /*
         * A) Dar de alta un Estudiante
         */
        /*mySqlFactory.getEstudianteRepository().add(converterEstudiante.fromDTO(e1));
        mySqlFactory.getEstudianteRepository().add(converterEstudiante.fromDTO(e2));
        mySqlFactory.getEstudianteRepository().add(converterEstudiante.fromDTO(e3));
        mySqlFactory.getCarreraRepository().add(converterCarrera.fromDTO(c1));
        mySqlFactory.getCarreraRepository().add(converterCarrera.fromDTO(c2));*/

        /*
         * B) Matricular un estudiante
         */
        /*Estudiante e = converterEstudiante.fromDTO(e1);
        Carrera c = converterCarrera.fromDTO(c2);
        CursaId cs1_id = new CursaId(e.getDniEstudiante(), c.getIdCarrera());
        Cursa cs1 = new Cursa(cs1_id, e, c, 2, false);
        mySqlFactory.getCursaRepository().add(cs1);
        /*DA ERROR: Si el estudiante ya esta persistido no deja agregar un registro en cursa Y
        repite el mismo objeto de carrera en la base
        e.addCursada(cs1);
        c.addEstudiantesMatriculados(cs1);*/

        /*
         * C) Recuperar todos los estudiantes bajo un criterio de ordenamiento
         */

        /*
         * D) Recuperar un estudiante en base a su nro de libreta
         */
        EstudianteDTO eDTO = converterEstudiante.fromEntity(mySqlFactory.getEstudianteRepository().findByNroLibreta(100L));
        System.out.println(eDTO);

        /*
         * E) Recuperar estudiantes en base a su genero
         */
        List<EstudianteDTO> resultado = converterEstudiante.fromEntity(mySqlFactory.getEstudianteRepository().findAllByGenero("M"));
        for(EstudianteDTO eDTO2 : resultado) {
            System.out.println(eDTO2);
        }

        /*
         * F) Recuperar todas las carreras con estudiantes inscriptos ordenados por cantidad de inscriptos
         */
        List<Object> resultado2 = mySqlFactory.getCarreraRepository().findAllByEstudiantesInscriptosOrderByCantidad();

     }
}
