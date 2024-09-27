import factories.MySqlFactory;
import model.Estudiante;
import repositories.EstudianteImp;

public class Main {
    public static void main(String[] args) {

        MySqlFactory mySqlFactory = MySqlFactory.getInstance();

        Estudiante e1 = new Estudiante(45037195L, "Lucho", "Torres", 20, 00001L, "M", "Tandil");

        EstudianteImp estudianteImp = mySqlFactory.getEstudianteImp();

        estudianteImp.add(e1);
        

    }
}
