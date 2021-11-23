package entity_joined;

import javax.persistence.*;

@Entity
@Table(name = "personal")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_personal",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
class PersonalJ {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String dni;
    private String nss,nombre,telefono;
    @Embedded
    private DireccionJ direccion;

    public PersonalJ() {
    }

    public PersonalJ(String dni, String nss, String nombre, String telefono, DireccionJ direccion) {
        this.dni = dni;
        this.nss = nss;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DireccionJ getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionJ direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "dni='" + dni + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}