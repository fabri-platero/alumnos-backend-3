package sesiones;

import entidad.Alumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }

    public List<Alumno> sinRendirEnAnio(int anio) {
        Timestamp desde = Timestamp.valueOf(LocalDateTime.of(anio, 1, 1, 0, 0));
        Timestamp hasta = Timestamp.valueOf(LocalDateTime.of(anio + 1, 1, 1, 0, 0));
        return em.createQuery(
                "SELECT a FROM Alumno a WHERE NOT EXISTS (SELECT e FROM Examen e WHERE e.alumno = a "
                + "AND e.examenPK.fecha >= :desde AND e.examenPK.fecha < :hasta)",
                Alumno.class)
                .setParameter("desde", desde)
                .setParameter("hasta", hasta)
                .getResultList();
    }
}