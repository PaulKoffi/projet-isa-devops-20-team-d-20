package fr.unice.polytech.isa.dd.webservices;

import fr.unice.polytech.isa.dd.Delivery;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/delivery")
@Stateless(name = "DeliveryWS")
public class DeliveryWebServicesImp implements DeliveryWebServicesInterface {

    @EJB(name="stateless-delivery") private NextDeliveryInterface nextDelivery;
    @Override
    public Delivery getNextDelivery() {
        return nextDelivery.getNextDelivery();
    }
}