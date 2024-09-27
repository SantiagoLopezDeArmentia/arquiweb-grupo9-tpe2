package repositories;

import model.Carrera;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraImp implements Repository<Carrera>{

    private EntityManager entityManager;
    private static CarreraImp instance;

    private CarreraImp(){
        super();
    }

    private CarreraImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public static CarreraImp getInstance(EntityManager entityManager){
        if(instance == null){
            instance = new CarreraImp(entityManager);
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
        return this.entityManager.createQuery("SELECT c FROM Carrera c").getResultList();
    }


}
