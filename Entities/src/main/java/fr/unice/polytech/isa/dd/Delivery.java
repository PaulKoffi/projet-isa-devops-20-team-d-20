package fr.unice.polytech.isa.dd;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Delivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Customer customer;

    @NotNull
    private Package packageDelivered;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private String beginTime;

    @NotNull
    private String endTime;

    private int customerMark;

    private double price;

    private boolean status;


    public Delivery() {
        // Necessary for JPA instantiation process
    }

    public Delivery(Customer c, Package p, Date d, String b) {
        customer = c;
        packageDelivered = p;
        deliveryDate = d;
        beginTime = b;
        status = false;
        /**** Calcul du prix basique pour le moment basé sur le poids (10 Euros / grammes) ****/
        price = p.getWeight() * 10;
    }

    public void setEndTime(String e) {
        endTime = e;
        status = true;
    }

    public void setCustomerMark(int m) {
        customerMark = m;
    }

    public void setStatus(boolean s) {
        status = s;
    }


    /*** ecriture de la méthode equals et hash à faire ****/

}
