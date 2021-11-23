package entity_tpc;

import javax.persistence.Embeddable;

@Embeddable
public class DireccionTPC {
    private String calle;
    private int numero;

    public DireccionTPC(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public DireccionTPC() {

    }


}
