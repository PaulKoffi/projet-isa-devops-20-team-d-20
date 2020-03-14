package fr.unice.polytech.isa.dd.business;

import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.*;
import fr.unice.polytech.isa.dd.entities.Package;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryBeanTest {

    @org.junit.Test
    public void getAllDayDeliveries() {

        List<Provider> providers;
        List<Delivery> delivs;
        DeliveryBean deliveryBeantest;

        providers = Database.getInstance().getProviderList();
        delivs = Database.getInstance().getDeliveryList();

        Customer c = new Customer("Pm","adresse1");
        DateTime dt = new DateTime();

        Provider pro1 = new Provider("1","Aug1");
        Provider pro2 = new Provider("2","Aug2");
        providers.add(pro1);providers.add(pro2);

        Package pk1 = new Package("1",2.0,dt,"1");
        Package pk2 = new Package("2",2.0,dt,"1");
        Package pk3 = new Package("3",2.0,dt,"2");

        Delivery d1 = new Delivery(c,pk1,dt,null) ;
        Delivery d2 = new Delivery(c,pk2,dt,null) ;
        Delivery d3 = new Delivery(c,pk3,dt,null) ;


        delivs.add(d1);delivs.add(d2);delivs.add(d3);


        deliveryBeantest = new DeliveryBean();
        HashMap<Provider,List<Delivery>> alldeliveries = deliveryBeantest.getAllDayDeliveries();

        for(Provider provider : providers){
            assertEquals(0,alldeliveries.get(provider).size());
        }
    }

   @org.junit.Test
    public void getAllDeliveries() {

        DeliveryBean deliveryBeantest = new DeliveryBean();

        List<Delivery> providers_delivs = deliveryBeantest.getAllDeliveries("1");

        assertEquals(2,providers_delivs.size());
    }

    @Test
    public void getNextDelivery(){

        List<Delivery> delivs = Database.getInstance().getDeliveryList();

        DeliveryBean deliveryBeantest = new DeliveryBean();
        DeliveryBean deliveryBeanTestNull = new DeliveryBean();

        Delivery nextdelivery = deliveryBeanTestNull.getNextDelivery();

        assertNotNull(nextdelivery);

        delivs.get(0).setStatus(true);
        nextdelivery = deliveryBeantest.getNextDelivery();
        assertTrue(delivs.get(1).equals(nextdelivery));

        delivs.get(1).setStatus(true);
        nextdelivery = deliveryBeantest.getNextDelivery();
        assertFalse(delivs.get(1).equals(nextdelivery));
    }
}