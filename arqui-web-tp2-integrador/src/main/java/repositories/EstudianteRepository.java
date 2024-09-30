package repositories;

import model.Entities.Estudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteRepository implements Repository<Estudiante> {

    private EntityManager entityManager;
    private static EstudianteRepository instance;

    private EstudianteRepository() {
        super();
    }

    private EstudianteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static EstudianteRepository getInstance(EntityManager entityManager) {
        if (instance == null) {
            instance = new EstudianteRepository(entityManager);
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
        return this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();

    }

    public List<Estudiante> findAllByOrder() {
        this.entityManager.clear();
        String sql = "SELECT e FROM Estudiante e ORDER BY e.nroLibreta ASC ";
        return this.entityManager.createQuery(sql, Estudiante.class).getResultList();
    }

    public Estudiante findByNroLibreta(Long nroLibreta) {
        String sql = "SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta";
        return this.entityManager.createQuery(sql, Estudiante.class).setParameter("nroLibreta", nroLibreta).getSingleResult();
    }

    public List<Estudiante> findAllByGenero(String genero) {
        String sql = "SELECT e FROM Estudiante e WHERE e.genero = :genero";
        return this.entityManager.createQuery(sql, Estudiante.class).setParameter("genero", genero).getResultList();
    }

    public List<Estudiante> findAllByCarreraFilterByCiudad(String carrera,String ciudad) {
        String jpql = "SELECT e FROM Estudiante e " +
                "JOIN Cursa cs ON cs.id.dniEstudiante = e.dniEstudiante " +
                "JOIN Carrera c ON cs.id.idCarrera = c.idCarrera " +
                "WHERE e.ciudad = :ciudad AND c.nombreCarrera = :carrera";
        return entityManager.createQuery(jpql, Estudiante.class).setParameter("ciudad", ciudad).setParameter("carrera", carrera).getResultList();
    }
}
