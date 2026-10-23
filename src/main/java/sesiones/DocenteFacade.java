package sesiones;

import entidad.Docente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DocenteFacade extends AbstractFacade<Docente> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteFacade() {
        super(Docente.class);
    }

    public List<Docente> conMasDeDosMaterias() {
        return em.createQuery(
                "SELECT d FROM Docente d WHERE SIZE(d.materiaCollection) > 2", Docente.class)
                .getResultList();
    }
}