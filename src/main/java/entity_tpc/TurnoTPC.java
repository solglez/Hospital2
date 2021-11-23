package entity_tpc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class TurnoTPC {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTurno;
    @Column(name = "hora_ini")
    private Date horaInicio;
    private Date horaFin;

    @ManyToOne( fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "planta")
    private PlantaTPC planta;

    @ManyToMany(mappedBy = "lturnos")
    private List<CeladorTPC> lceladores;

    @ManyToMany(mappedBy = "lturnos")
    private List<LimpiadorTPC> llimpiadores;

    public TurnoTPC() {
    }

    public TurnoTPC(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        llimpiadores=new ArrayList<LimpiadorTPC>();
        lceladores=new ArrayList<CeladorTPC>();
    }

    public TurnoTPC(Date horaInicio, Date horaFin, PlantaTPC planta) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.planta = planta;
        llimpiadores=new ArrayList<LimpiadorTPC>();
        lceladores=new ArrayList<CeladorTPC>();
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

    public PlantaTPC getPlanta() {
        return planta;
    }

    public void setPlanta(PlantaTPC planta) {
        this.planta = planta;
    }

    public void addCelador(CeladorTPC c){
        lceladores.add(c);
        c.addTurno(this);
    }

    public void addLimpiador(LimpiadorTPC l){
        llimpiadores.add(l);
        l.addTurno(this);
    }
}
