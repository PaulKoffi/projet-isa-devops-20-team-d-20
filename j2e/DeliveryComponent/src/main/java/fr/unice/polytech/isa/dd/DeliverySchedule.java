package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Provider;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeliverySchedule {

    public List<Provider> providerList();

    public List<Delivery> get_deliveries();
}
