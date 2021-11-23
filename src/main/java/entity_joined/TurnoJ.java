package entity_joined;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turnos")
public class TurnoJ {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTurno;
    @Column(name = "hora_ini")
    private Date horaInicio;
    private Date horaFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planta")
    private PlantaJ planta;

    @ManyToMany(mappedBy = "lturnos")
    private List<CeladorJ> lceladores;

    @ManyToMany(mappedBy = "lturnos")
    private List<LimpiadorJ> llimpiadores;

    public TurnoJ() {
    }

    public TurnoJ(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        lceladores=new ArrayList<CeladorJ>();
        llimpiadores=new ArrayList<LimpiadorJ>();
    }

    public TurnoJ(Date horaInicio, Date horaFin, PlantaJ planta) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.planta = planta;
        lceladores=new ArrayList<CeladorJ>();
        llimpiadores=new ArrayList<LimpiadorJ>();
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public PlantaJ getPlanta() {
        return planta;
    }

    public void setPlanta(PlantaJ planta) {
        this.planta = planta;
    }

    public void addCelador(CeladorJ c){
        lceladores.add(c);
        c.addTurno(this);
    }

    public void addLimpiador(LimpiadorJ l){
        llimpiadores.add(l);
        l.addTurno(this);
    }
}
