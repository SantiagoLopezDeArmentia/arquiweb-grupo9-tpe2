package repositories;

import model.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteImp implements Repository<Estudiante>, EstudianteRepository {

    private EntityManager entityManager;
    private static EstudianteImp instance;

    private EstudianteImp() {
        super();
    }

    private EstudianteImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static EstudianteImp getInstance(EntityManager entityManager) {
        if (instance == null) {
            instance = new EstudianteImp(entityManager);
        }
        return instance;
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

    @Override
    public List<Estudiante> findAllByOrder(String columnName) {
        System.out.println("pase por aca");
        this.entityManager.clear();
        //String sql = "SELECT e FROM Estudiante e ORDER BY :columnName ASC ";
        String sql = "SELECT e FROM Estudiante e ORDER BY e.nro_libreta ASC ";
        //return this.entityManager.createQuery(sql).setParameter("columnName", columnName).getResultList();
        //TypedQuery<Estudiante> typedQuery =this.entityManager.createQuery("SELECT e FROM Estudiante e ORDER BY e.nro_libreta ASC ", Estudiante.class);
        //TypedQuery<Estudiante> typedQuery =this.entityManager.createQuery(sql, Estudiante.class).setParameter("columnName", columnName);
        TypedQuery<Estudiante> typedQuery =this.entityManager.createQuery(sql, Estudiante.class);

        //return this.entityManager.createQuery("SELECT e FROM Estudiante e ORDER BY e.nro_libreta DESC ", Estudiante.class).getResultList();

        return typedQuery.getResultList();
    }

    public Estudiante findByNroLibreta(Long nro_libreta) {
        String sql = "SELECT e FROM Estudiante e WHERE e.nro_libreta = :nro_libreta";
        return this.entityManager.createQuery(sql, Estudiante.class).setParameter("nro_libreta", nro_libreta).getSingleResult();
    }

    public List<Estudiante> findAllByGenero(String genero) {
        String sql = "SELECT e FROM Estudiante e WHERE e.genero = :genero";
        return this.entityManager.createQuery(sql).setParameter("genero", genero).getResultList();
    }
}
