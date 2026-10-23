package entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ExamenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_idmateria", nullable = false)
    private int materiaIdmateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno_idalumno", nullable = false)
    private int alumnoIdalumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ExamenPK() {
    }

    public ExamenPK(int materiaIdmateria, int alumnoIdalumno, Date fecha) {
        this.materiaIdmateria = materiaIdmateria;
        this.alumnoIdalumno = alumnoIdalumno;
        this.fecha = fecha;
    }

    public int getMateriaIdmateria() { return materiaIdmateria; }
    public void setMateriaIdmateria(int materiaIdmateria) { this.materiaIdmateria = materiaIdmateria; }

    public int getAlumnoIdalumno() { return alumnoIdalumno; }
    public void setAlumnoIdalumno(int alumnoIdalumno) { this.alumnoIdalumno = alumnoIdalumno; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public int hashCode() {
        return Objects.hash(materiaIdmateria, alumnoIdalumno, fecha);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ExamenPK)) {
            return false;
        }
        ExamenPK other = (ExamenPK) object;
        return this.materiaIdmateria == other.materiaIdmateria
                && this.alumnoIdalumno == other.alumnoIdalumno
                && Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return "entidad.ExamenPK[ materiaIdmateria=" + materiaIdmateria
                + ", alumnoIdalumno=" + alumnoIdalumno + ", fecha=" + fecha + " ]";
    }
}