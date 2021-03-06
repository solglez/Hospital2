import entity_joined.*;
//import entity_st.*;
//import entity_tpc.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        LocalDate ini_turno = LocalDate.of(2021,11,21);
        LocalDate fin_turno = LocalDate.of(2021, 11, 22);
        PlantaJ planta1 = new PlantaJ(1);
        TurnoJ t1 = new TurnoJ(ini_turno,fin_turno,planta1);
        DireccionJ dir1 = (new DireccionJ("Avda. Barcelona",82));
        DireccionJ dir2 = (new DireccionJ("Calle Africa",123));
        DireccionJ dir3 = (new DireccionJ("Travesía de Vigo",50));
        DireccionJ dir4 = (new DireccionJ("Calle falsa",123));
        CeladorJ c1 = new CeladorJ("00000000T","36112211","Marcos","666111666",dir1);
        LimpiadorJ l1 = new LimpiadorJ("12345678Z","36012201","Maria","711245331",dir2);
        c1.addTurno(t1);
        l1.addTurno(t1);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(l1);
        em.persist(t1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
