package entity_tpc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plantas")
public class PlantaTPC {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numero;

    @OneToMany(mappedBy = "planta", cascade = CascadeType.ALL)
    private List<TurnoTPC> lturnos;

    public PlantaTPC() {
    }

    public PlantaTPC(int numero) {
        this.numero = numero;
        lturnos=new ArrayList<TurnoTPC>();
    }

    public void addTurno(TurnoTPC t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoTPC t) {
        lturnos.remove(t);
    }

    public int getIdPlanta() {
        return numero;
    }

}
