package fr.unice.polytech.isa.dd.webservices;

import fr.unice.polytech.isa.dd.Delivery;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/delivery")
//@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/delivery")
//@WebService(targetNamespace = "http://www.group_d.fr.polytech.unice.isa.dd.DeliveryCare")
public interface DeliveryWebServicesInterface {

    @WebMethod
    @WebResult(name="the_next_delivery")
    Delivery getNextDelivery();

}
