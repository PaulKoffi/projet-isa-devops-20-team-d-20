package fr.unince.polytech.isa.dd;

import fr.unice.polytech.isa.dd.Delivery;
import fr.unice.polytech.isa.dd.DeliveryStatusInterface;
import fr.unice.polytech.isa.dd.Drone;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/delivery")
@Stateless(name = "DeliveryWS")
public class DeliveryWebServicesImpl implements DeliveryWebServicesInterface {

    @EJB(name="staless_delivery") private DeliveryStatusInterface deliveryStatusInterface;

    @Override
    public <Optional> Delivery getNextDelivery() {
        return null;
    }
}
