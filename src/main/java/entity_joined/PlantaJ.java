package entity_joined;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plantas")
public class PlantaJ {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numero;

    @OneToMany(mappedBy = "planta", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<TurnoJ> lturnos;

    public PlantaJ() {
    }

    public PlantaJ(int numero) {
        this.numero = numero;
        lturnos=new ArrayList<TurnoJ>();
    }

    public void addTurno(TurnoJ t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoJ t) {
        lturnos.remove(t);
    }

    public int getIdPlanta() {
        return numero;
    }

}
