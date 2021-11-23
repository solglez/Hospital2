package entity_joined;

import javax.persistence.Embeddable;

@Embeddable
public class DireccionJ {
    private String calle;
    private int numero;

    public DireccionJ(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public DireccionJ() {

    }


}
