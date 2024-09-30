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

        List<Estudiante> est = mySqlFactory.getEstudianteRepository().findAll();
        for (Estudiante estudiante : est) {
            System.out.println(estudiante);
        }
        /*
         * A) Dar de alta un Estudiante
         */
        System.out.println("\nServicio 2 - Inciso A)");

        Carrera c = converterCarrera.fromDTO(c2);
        Carrera car2 = converterCarrera.fromDTO(c1);

        Estudiante e = converterEstudiante.fromDTO(e1);
        Estudiante est2 = converterEstudiante.fromDTO(e2);
        Estudiante est3 = converterEstudiante.fromDTO(e3);

        mySqlFactory.getEstudianteRepository().add(e);
        mySqlFactory.getEstudianteRepository().add(est2);
        mySqlFactory.getEstudianteRepository().add(est3);

        mySqlFactory.getCarreraRepository().add(car2);
        mySqlFactory.getCarreraRepository().add(c);

        /*
         * B) Matricular un estudiante
         */
        System.out.println("\nServicio 2 - Inciso B)");
        CursaId cs1_id = new CursaId(e.getDniEstudiante(), c.getIdCarrera());
        Cursa cs1 = new Cursa(cs1_id, e, c, 2, false);
        mySqlFactory.getCursaRepository().add(cs1);

        CursaId cs2_id = new CursaId(est2.getDniEstudiante(), c.getIdCarrera());
        Cursa cs2 = new Cursa(cs2_id, est2, c, 2, false);
        mySqlFactory.getCursaRepository().add(cs2);

        CursaId cs3_id = new CursaId(est3.getDniEstudiante(), c.getIdCarrera());
        Cursa cs3 = new Cursa(cs3_id, est3, c, 2, false);
        mySqlFactory.getCursaRepository().add(cs3);

        CursaId cs4_id = new CursaId(e.getDniEstudiante(), car2.getIdCarrera());
        Cursa cs4 = new Cursa(cs4_id, e, car2, 2, false);
        mySqlFactory.getCursaRepository().add(cs4);

        CursaId cs5_id = new CursaId(est2.getDniEstudiante(), car2.getIdCarrera());
        Cursa cs5 = new Cursa(cs5_id, est2, car2, 2, false);
        mySqlFactory.getCursaRepository().add(cs5);




        /*
         * C) Recuperar todos los estudiantes bajo un criterio de ordenamiento
         */
        System.out.println("\nServicio 2 - Inciso C)");
        List<Estudiante> estudiantesDTO = mySqlFactory.getEstudianteRepository().findAllByOrder();
        for (Estudiante estudiante : estudiantesDTO) {
            System.out.println(converterEstudiante.fromEntity(estudiante));
        }

        /*
         * D) Recuperar un estudiante en base a su nro de libreta
         */
        System.out.println("\nServicio 2 - Inciso D)");
        EstudianteDTO eDTO = converterEstudiante.fromEntity(mySqlFactory.getEstudianteRepository().findByNroLibreta(100L));
        System.out.println(eDTO);

        /*
         * E) Recuperar estudiantes en base a su genero
         */
        System.out.println("\nServicio 2 - Inciso E)");
        List<EstudianteDTO> resultado = converterEstudiante.fromEntity(mySqlFactory.getEstudianteRepository().findAllByGenero("M"));
        for(EstudianteDTO eDTO2 : resultado) {
            System.out.println(eDTO2);
        }

        /*
         * F) Recuperar todas las carreras con estudiantes inscriptos ordenados por cantidad de inscriptos
         */
        System.out.println("\nServicio 2 - Inciso F)");
        List<CarreraInscriptosDTO> resultado2 = mySqlFactory.getCarreraRepository().findAllByEstudiantesInscriptosOrderByCantidad();

        for(CarreraInscriptosDTO eDTO2 : resultado2) {
            System.out.println(eDTO2);
        }

        /*
         * G)  recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
         * */
        System.out.println("\nServicio 2 - Inciso G)");

        List<Estudiante> estudiantesG = mySqlFactory.getEstudianteRepository().findAllByCarreraFilterByCiudad("TUDAI", "Tandil");
        for(Estudiante estudiante : estudiantesG) {
            System.out.println(converterEstudiante.fromEntity(estudiante));
        }


     }
}
