package repositories;

import model.Cursa;

import javax.persistence.EntityManager;
import java.util.List;

public class CursaImp implements Repository<Cursa>{

    private EntityManager entityManager;
    private static CursaImp instance;

    private CursaImp() { super(); }

    private CursaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static CursaImp getInstance(EntityManager entityManager) {
        if (instance == null) {
            instance = new CursaImp(entityManager);
        }
        return instance;
    }

    @Override
    public void add(Cursa cursa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(cursa);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void update(Cursa cursa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(cursa);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Cursa cursa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(cursa);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Cursa find(Long id) {
        return this.entityManager.find(Cursa.class, id);
    }

    @Override
    public List<Cursa> findAll() {
        return this.entityManager.createQuery("SELECT c FROM Cursa c").getResultList();
    }
}
