package entity_st;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="2")
@Table(name = "limpiadores")
public class LimpiadorST extends PersonalST {

    @ManyToMany
    @JoinTable(name = "limp_turno",joinColumns = @JoinColumn(name="dni_limpiador"),
            inverseJoinColumns = @JoinColumn(name="idTurno"))
    private List<TurnoST> lturnos;

    public LimpiadorST(String dni, String nss, String nombre, String telefono, DireccionST direccion) {
        super(dni, nss, nombre, telefono, direccion);
        lturnos=new ArrayList<TurnoST>();
    }

    public LimpiadorST() {

    }

    public void addTurno(TurnoST t) {
        lturnos.add(t);
    }
    public void removeTurno(TurnoST t) {
        lturnos.remove(t);
    }


}
