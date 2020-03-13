package fr.unice.polytech.isa.dd;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeliveryInterface {

    //Changer le type de retour de ces fonctions en Livraison
    public void getAllDayDeliveries(String provider_id);
    public List<Delivery> getAllDeliveries(String provider_id);


}
