import factories.MySqlFactory;
import model.Carrera;
import model.Cursa;
import model.CursaId;
import model.Estudiante;
import repositories.CarreraImp;
import repositories.CursaImp;
import repositories.EstudianteImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MySqlFactory mySqlFactory = MySqlFactory.getInstance();

        Estudiante e1 = new Estudiante(45037195L, "Lucho", "Torres", 20, 00001L, "M", "Tandil");
        Carrera c1 = new Carrera(1L, "TUDAI");
        Estudiante e2 = new Estudiante(12456987L, "Rosta", "Chaka", 18, 00002L, "F", "Tandil");
        Estudiante e3 = new Estudiante(11122233L, "Marijuana", "Esquina", 37, 00012L, "F", "Olaburrida");

        EstudianteImp estudianteImp = mySqlFactory.getEstudianteImp();
        CarreraImp carreraImp = mySqlFactory.getCarreraImp();
        CursaImp cursaImp = mySqlFactory.getCursaImp();

        /* Ejecicio 2
        * a. Dar de alta estudiante */
        estudianteImp.add(e1);
        estudianteImp.add(e2);
        estudianteImp.add(e3);


        /* Ejecicio 2
         * b. matricular un estudiante a una carrera */
        CursaId cursaId_e1_c1 =  new CursaId(e1.getDni_estudiante(), c1.getId_carrera());
        Cursa cursa_e1_c1 = new Cursa(cursaId_e1_c1, e1, c1, 5, false);

        carreraImp.add(c1);
        cursaImp.add(cursa_e1_c1);
        c1.addEstudiantesMatriculados(cursa_e1_c1);
        e1.addCarrera(cursa_e1_c1);

        estudianteImp.update(e1);

        /* Ejercicio 2
        * c. recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        * */

        //List<Estudiante> estudiantes = estudianteImp.findAll();
        List<Estudiante> estudiantes = estudianteImp.findAllByOrder("nro_libreta");
        for (Estudiante est : estudiantes) {
            System.out.println(est);
        }

        /* Ejercicio 2
         * d) recuperar un estudiante, en base a su número de libreta universitaria.
         * */
        System.out.println("\nEjercicio 2\n" +
                " d) recuperar un estudiante, en base a su número de libreta universitaria.");
        Estudiante estudianteByNroLibreta = estudianteImp.findByNroLibreta(2L);
        System.out.println(estudianteByNroLibreta);

        /* Ejercicio 2
         * e) recuperar todos los estudiantes, en base a su género.
         * */
        System.out.println("\nEjercicio 2\n" +
                "e) recuperar todos los estudiantes, en base a su género.");
        List<Estudiante> estudiantesByGenero = estudianteImp.findAllByGenero("F");
        for (Estudiante est : estudiantesByGenero) {
            System.out.println(est);
        }
    }
}
