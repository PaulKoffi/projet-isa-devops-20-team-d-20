package fr.unice.polytech.isa.dd.webservice;

import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.entities.Database;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService")
//@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/delivery")
//@WebService(targetNamespace = "http://www.group_d.fr.polytech.unice.isa.dd.DeliveryCare")
@Stateless(name = "DeliveryWS")
public class DeliveryWebServiceImp implements DeliveryWebService {

    @EJB private NextDeliveryInterface nextDelivery;

    @Override
//    public Delivery getNextDelivery(Delivery delivery) {
    public Delivery getNextDelivery() {
        System.out.println("Passage dans mon service 1");
        Delivery d = nextDelivery.getNextDelivery();
//        System.out.println("le prix est " + d.getPrice());
        return d;
    }

    @Override
    public void initializeDelivery() {
        Database.getInstance().initializeDatabase();
    }

    //    @Override
//    public Delivery getN(DroneStatus a){
//        System.out.println("Passage dans mon service 1");
//        Delivery d = nextDelivery.getNextDelivery();
//        System.out.println("le prix est " + d.getPrice());
//        return d;
//    }

}