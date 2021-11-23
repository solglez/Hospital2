package entity_tpc;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class PersonalTPC {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String dni;
    private String nss,nombre,telefono;
    @Embedded
    private DireccionTPC direccion;

    public PersonalTPC() {
    }

    public PersonalTPC(String dni, String nss, String nombre, String telefono, DireccionTPC direccion) {
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

    public DireccionTPC getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionTPC direccion) {
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