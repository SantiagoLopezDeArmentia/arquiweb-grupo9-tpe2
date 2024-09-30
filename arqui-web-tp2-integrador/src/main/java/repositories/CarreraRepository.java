package repositories;

import model.Carrera;
import model.dto.CarreraInscriptosDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraRepository implements Repository<Carrera> {

    private EntityManager entityManager;
    private static CarreraRepository instance;

    private CarreraRepository(){
        super();
    }

    private CarreraRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public static CarreraRepository getInstance(EntityManager entityManager){
        if(instance == null){
            instance = new CarreraRepository(entityManager);
        }
        return instance;
    }

    @Override
    public void add(Carrera carrera) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(carrera);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void update(Carrera carrera) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(carrera);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Carrera carrera) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(carrera);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Carrera find(Long id) {
        return this.entityManager.find(Carrera.class, id);
    }

    @Override
    public List<Carrera> findAll() {
        return this.entityManager.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
    }

    public List<CarreraInscriptosDTO> findAllByEstudiantesInscriptosOrderByCantidad() {
        List<CarreraInscriptosDTO> list = entityManager.createQuery(
                "SELECT new model.dto.CarreraInscriptosDTO(" +
                        "c.nombreCarrera, " +
                        "count(cs.id.dniEstudiante)" +
                        ") " +
                        "FROM Carrera c " +
                        "JOIN Cursa cs ON c.idCarrera = cs.id.idCarrera " +
                        "GROUP BY c.idCarrera "+
                        "ORDER BY count(cs.id.dniEstudiante) DESC"
                , CarreraInscriptosDTO.class).getResultList();
        return list;

    }
}
