package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Provider;

import javax.ejb.Local;
import java.util.HashMap;
import java.util.List;

@Local
public interface DeliveryInterface {

    //Changer le type de retour de ces fonctions en Livraison
    public HashMap<Provider,List<Delivery>> getAllDayDeliveries();
    public List<Delivery> getAllDeliveries(String provider_id);


}
