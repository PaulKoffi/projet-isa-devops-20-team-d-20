package fr.unince.polytech.isa.dd;


import fr.unice.polytech.isa.dd.Delivery;
import fr.unice.polytech.isa.dd.Drone;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/tcf/cart")

public interface DeliveryWebServicesInterface {

    @WebMethod
    @WebResult(name = "all_loading_drones")
    <Optional> Delivery getNextDelivery();
}
