package repositories;

import model.Entities.Carrera;
import model.dto.CarreraInscriptosDTO;
import model.dto.ReporteDTO;

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

    public List<ReporteDTO> servicio3() {
        String jpql = "SELECT new model.dto.ReporteDTO (" +
                "c.nombreCarrera, cs.fechaInicio, count(cs.fechaInicio), count(cs.fechaFin)) " +
                "FROM Carrera c " +
                "JOIN Cursa cs ON cs.id.idCarrera = c.idCarrera " +
                "GROUP BY c.nombreCarrera, cs.fechaInicio, cs.fechaFin " +
                "ORDER BY c.nombreCarrera, cs.fechaInicio";
        return this.entityManager.createQuery(jpql, ReporteDTO.class).getResultList();

    }
}
