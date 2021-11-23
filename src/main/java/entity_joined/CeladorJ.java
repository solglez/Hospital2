package entity_joined;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "celadores")
@DiscriminatorValue(value="1")
public class CeladorJ extends PersonalJ {

    @ManyToMany
    @JoinTable(name = "cel_turno",joinColumns = @JoinColumn(name="dni_celador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoJ> lturnos;

    public CeladorJ(String dni, String nss, String nombre, String telefono, DireccionJ direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoJ>();
    }

    public CeladorJ() {

    }

    public void addTurno(TurnoJ t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoJ t) {
        lturnos.remove(t);
    }
}
