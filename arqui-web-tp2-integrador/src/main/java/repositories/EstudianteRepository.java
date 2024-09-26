package repositories;

import model.Estudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteRepository implements Repository<Estudiante>{

    private EntityManager entityManager;

    public EstudianteRepository() {
        super();
    }

    public EstudianteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Estudiante estudiante) {
        this.entityManager.getTransaction().begin();
        entityManager.persist(estudiante);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Estudiante estudiante) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(estudiante);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void update(Estudiante estudiante) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(estudiante);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Estudiante find(Long id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> findAll() {
        return this.entityManager.createQuery("SELECT e FROM Estudiante e").getResultList();

    }
}
