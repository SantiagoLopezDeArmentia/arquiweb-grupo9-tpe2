package factories;

import repositories.CarreraRepository;
import repositories.CursaRepository;
import repositories.EstudianteRepository;

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

    public CursaRepository getCursaRepository(){
        return CursaRepository.getInstance(this.entityManager);
    }

    public CarreraRepository getCarreraRepository() {
        return CarreraRepository.getInstance(this.entityManager);
    }

    public EstudianteRepository getEstudianteRepository() {
        return EstudianteRepository.getInstance(this.entityManager);
    }

}
