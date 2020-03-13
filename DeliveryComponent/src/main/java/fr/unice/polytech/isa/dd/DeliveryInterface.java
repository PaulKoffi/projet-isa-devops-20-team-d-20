package fr.unice.polytech.isa.dd;

import java.util.List;

public interface DeliveryInterface {

    //Changer le type de retour de ces fonctions en Livraison
    public void getAllDayDeliveries(String provider_id);
    public List<Delivery> getAllDeliveries(String provider_id);


}
