package repositories;

import model.Carrera;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraRepository implements Repository<Carrera>{

    private EntityManager entityManager;

    public CarreraRepository(){
        super();
    }

    public CarreraRepository(EntityManager em){
        this.entityManager = em;
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
