package entity_tpc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "limpiadores")
public class LimpiadorTPC extends PersonalTPC {

    @ManyToMany
    @JoinTable(name = "limp_turno",joinColumns = @JoinColumn(name="dni_limpiador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoTPC> lturnos;

    public LimpiadorTPC(String dni, String nss, String nombre, String telefono, DireccionTPC direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoTPC>();
    }

    public LimpiadorTPC() {

    }

    public void addTurno(TurnoTPC t) {
        lturnos.add(t);
    }
    public void removeTurno(TurnoTPC t) {
        lturnos.remove(t);
    }


}
