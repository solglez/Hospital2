package entity_st;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plantas")
public class PlantaST {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numero;

    @OneToMany(mappedBy = "planta", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<TurnoST> lturnos;

    public PlantaST() {
    }

    public PlantaST(int numero) {
        this.numero = numero;
        lturnos=new ArrayList<TurnoST>();
    }

    public void addTurno(TurnoST t) {
        lturnos.add(t);

    }

    public void removeTurno(TurnoST t) {
        lturnos.remove(t);
    }

    public int getIdPlanta() {
        return numero;
    }

}
