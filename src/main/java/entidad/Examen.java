package entidad;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "examen", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByNota", query = "SELECT e FROM Examen e WHERE e.nota = :nota")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenPK examenPK;
    @Column(name = "nota")
    private Integer nota;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "materia_idmateria", referencedColumnName = "idmateria", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Examen() {
    }

    public Examen(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public ExamenPK getExamenPK() { return examenPK; }
    public void setExamenPK(ExamenPK examenPK) { this.examenPK = examenPK; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }

    @Override
    public int hashCode() {
        return examenPK != null ? examenPK.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        return !((this.examenPK == null && other.examenPK != null)
                || (this.examenPK != null && !this.examenPK.equals(other.examenPK)));
    }

    @Override
    public String toString() {
        return "entidad.Examen[ examenPK=" + examenPK + " ]";
    }
}