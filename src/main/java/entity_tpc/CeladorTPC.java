package entity_tpc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "celadores")
public class CeladorTPC extends PersonalTPC {

    @ManyToMany
    @JoinTable(name = "cel_turno",joinColumns = @JoinColumn(name="dni_celador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoTPC> lturnos;

    public CeladorTPC(String dni, String nss, String nombre, String telefono, DireccionTPC direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoTPC>();
    }

    public CeladorTPC() {

    }

    public void addTurno(TurnoTPC t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoTPC t) {
        lturnos.remove(t);
    }
}
