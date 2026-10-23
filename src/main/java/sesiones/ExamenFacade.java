package sesiones;

import entidad.Examen;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class ExamenFacade extends AbstractFacade<Examen> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamenFacade() {
        super(Examen.class);
    }

    public List<Examen> mesasDeJulio(int anio) {
        Timestamp desde = Timestamp.valueOf(LocalDateTime.of(anio, 7, 1, 0, 0));
        Timestamp hasta = Timestamp.valueOf(LocalDateTime.of(anio, 8, 1, 0, 0));
        return em.createQuery(
                "SELECT e FROM Examen e WHERE e.examenPK.fecha >= :desde AND e.examenPK.fecha < :hasta ORDER BY e.examenPK.fecha",
                Examen.class)
                .setParameter("desde", desde)
                .setParameter("hasta", hasta)
                .getResultList();
    }
}