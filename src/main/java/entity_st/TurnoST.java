package entity_st;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turnos")
public class TurnoST {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTurno;
    @Column(name = "hora_ini")
    private Date horaInicio;
    private Date horaFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planta")
    private PlantaST planta;

    @ManyToMany(mappedBy = "lturnos")
    private List<CeladorST> lceladores;

    @ManyToMany(mappedBy = "lturnos")
    private List<LimpiadorST> llimpiadores;

    public TurnoST() {
    }

    public TurnoST(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        llimpiadores=new ArrayList<LimpiadorST>();
        lceladores=new ArrayList<CeladorST>();
    }

    public TurnoST(Date horaInicio, Date horaFin, PlantaST planta) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.planta = planta;
        llimpiadores=new ArrayList<LimpiadorST>();
        lceladores=new ArrayList<CeladorST>();
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

    public PlantaST getPlanta() {
        return planta;
    }

    public void setPlanta(PlantaST planta) {
        this.planta = planta;
    }

    public void addCelador(CeladorST c){
        lceladores.add(c);
        c.addTurno(this);
    }

    public void addLimpiador(LimpiadorST l){
        llimpiadores.add(l);
        l.addTurno(this);
    }
}
