package entity_joined;

import jdk.vm.ci.meta.Local;

import javax.persistence.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "turnos")
public class TurnoJ {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTurno;
    @Column(name = "hora_ini")
    private LocalDate fchInicio;
    private LocalDate fchFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planta")
    private PlantaJ planta;

    @ManyToMany(mappedBy = "lturnos")
    private List<CeladorJ> lceladores;

    @ManyToMany(mappedBy = "lturnos")
    private List<LimpiadorJ> llimpiadores;

    public TurnoJ() {
    }

    public TurnoJ(LocalDate fchInicio, LocalDate fchFin) {
        this.fchInicio = fchInicio;
        this.fchFin = fchFin;
        lceladores=new ArrayList<CeladorJ>();
        llimpiadores=new ArrayList<LimpiadorJ>();
    }

    public TurnoJ(LocalDate fchInicio, LocalDate fchFin, PlantaJ planta) {
        this.fchInicio = fchInicio;
        this.fchFin = fchFin;
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

    public LocalDate getfchInicio() {
        return fchInicio;
    }

    public void setfchInicio(LocalDate fchInicio) {
        this.fchInicio = fchInicio;
    }

    public LocalDate getfchFin() {
        return fchFin;
    }

    public void setfchFin(LocalDate fchFin) {
        this.fchFin = fchFin;
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
