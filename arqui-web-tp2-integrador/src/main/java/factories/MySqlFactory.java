package factories;

import repositories.CarreraImp;
import repositories.CursaImp;
import repositories.EstudianteImp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MySqlFactory {

    private EntityManager entityManager;
    private static MySqlFactory instance;

    private MySqlFactory(){
        this.getConnection();
        instance = this;
    }

    private void getConnection() {
        this.entityManager = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }

    public static MySqlFactory getInstance(){
        if (instance == null){
            instance = new MySqlFactory();
        }
        return instance;
    }

    public CursaImp getCursaImp(){
        return CursaImp.getInstance(this.entityManager);
    }

    public CarreraImp getCarreraImp() {
        return CarreraImp.getInstance(this.entityManager);
    }

    public EstudianteImp getEstudianteImp() {
        return EstudianteImp.getInstance(this.entityManager);
    }

}
