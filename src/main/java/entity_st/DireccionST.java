package entity_st;

import javax.persistence.Embeddable;

@Embeddable
public class DireccionST {
    private String calle;
    private int numero;

    public DireccionST(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public DireccionST() {

    }


}
