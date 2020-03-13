package fr.unice.polytech.isa.dd.business;

import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.Package;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryBeanTest {


    @org.junit.Test
    public void getAllDeliveries() {

        Customer c = new Customer("Pm","adresse1");
        DateTime dt = new DateTime();
        Package pk1 = new Package("1",2.0,dt,"1");
        Package pk2 = new Package("2",2.0,dt,"1");
        Package pk3 = new Package("3",2.0,dt,"2");

        Delivery d1 = new Delivery(c,pk1,dt,null) ;
        Delivery d2 = new Delivery(c,pk1,dt,null) ;
        Delivery d3 = new Delivery(c,pk1,dt,null) ;
        Delivery d4 = new Delivery(c,pk3,dt,null) ;

        List<Delivery> delivs = new ArrayList<>(Arrays.asList(d1,d2,d3,d4));

        DeliveryBean deliveryBeantest = new DeliveryBean(delivs);

        List<Delivery> providers_delivs = deliveryBeantest.getAllDeliveries("1");

        assertEquals(3,providers_delivs.size());
    }

    @Test
    public void getNextDelivery(){

        Customer c = new Customer("Pm","adresse1");
        DateTime dt = new DateTime();
        Package pk1 = new Package("1",2.0,dt,"1");
        Package pk2 = new Package("2",2.0,dt,"1");
        Package pk3 = new Package("3",2.0,dt,"2");

        Delivery d1 = new Delivery(c,pk1,dt,null) ;
        Delivery d2 = new Delivery(c,pk1,dt,null) ;
        Delivery d3 = new Delivery(c,pk1,dt,null) ;
        Delivery d4 = new Delivery(c,pk3,dt,null) ;

        d1.setStatus(true);


        List<Delivery> delivs = new ArrayList<>(Arrays.asList(d1,d2,d3,d4));

        DeliveryBean deliveryBeantest = new DeliveryBean(delivs);

        Delivery nextdelivery = deliveryBeantest.getNextDelivery();

        System.out.println(d3.equals(nextdelivery));

    }
}