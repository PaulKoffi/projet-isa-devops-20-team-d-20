package fr.unice.polytech.isa.dd.entities;
import org.joda.time.DateTime;

//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Random;
//import java.util.Date;

//@Embeddable
public class Delivery implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@NotNull

    private Customer customer;

    //@NotNull
    private Package packageDelivered;

    //@NotNull
    private DateTime deliveryDate;

    //@NotNull
    private String beginTime;

    //@NotNull
    private String endTime;

    private int customerMark;

    private double price;

    private boolean status;


    public Delivery() {
        // Necessary for JPA instantiation process
    }

    public Delivery(Customer c, Package p, DateTime d, String b) {
        //id = new Random().nextInt();
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

    public boolean getStatus(){
        return this.status;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Package getPackageDelivered() {
        return packageDelivered;
    }

    public DateTime getDeliveryDate() {
        return deliveryDate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getCustomerMark() {
        return customerMark;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPackageDelivered(Package packageDelivered) {
        this.packageDelivered = packageDelivered;
    }

    public void setDeliveryDate(DateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*** ecriture de la méthode equals et hash à faire ****/

}
