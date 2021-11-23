package entity_st;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="1")
@Table(name = "celadores")
public class CeladorST extends PersonalST {

    @ManyToMany
    @JoinTable(name = "cel_turno",joinColumns = @JoinColumn(name="dni_celador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoST> lturnos;

    public CeladorST(String dni, String nss, String nombre, String telefono, DireccionST direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoST>();
    }

    public CeladorST() {

    }

    public void addTurno(TurnoST t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoST t) {
        lturnos.remove(t);
    }
}
