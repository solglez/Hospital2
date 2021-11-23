package entity_joined;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "limpiadores")
@DiscriminatorValue(value="1")
public class LimpiadorJ extends PersonalJ {

    @ManyToMany
    @JoinTable(name = "limp_turno",joinColumns = @JoinColumn(name="dni_limpiador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoJ> lturnos;

    public LimpiadorJ(String dni, String nss, String nombre, String telefono, DireccionJ direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoJ>();
    }

    public LimpiadorJ() {

    }

    public void addTurno(TurnoJ t) {
        lturnos.add(t);
    }
    public void removeTurno(TurnoJ t) {
        lturnos.remove(t);
    }


}
