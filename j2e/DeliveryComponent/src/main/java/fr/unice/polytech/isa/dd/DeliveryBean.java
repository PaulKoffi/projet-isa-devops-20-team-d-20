package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Provider;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Stateless(name="delivery-stateless")
public class DeliveryBean implements DeliveryInterface, NextDeliveryInterface {


    HashMap<Provider, List<Delivery>> deliveries_by_provider = new HashMap<>();

    /*public DeliveryBean() {
        deliveries_by_provider = new HashMap<>();
    }*/

    @Override
    public HashMap<Provider, List<Delivery>> getAllDayDeliveries() {
        List<Provider> provider_set = Database.getInstance().getProviderList();
        for (Provider pro : provider_set) {
            List<Delivery> alldeliveries = getAllDeliveries(pro.getId());
            if (!alldeliveries.isEmpty()) {
                alldeliveries = alldeliveries.stream().filter(d -> d.getStatus()).collect(Collectors.toList());
                this.deliveries_by_provider.put(pro, alldeliveries);
            }
        }
        return deliveries_by_provider;
    }

    @Override
    public List<Delivery> getAllDeliveries(int provider_id) {
        List<Delivery> deliveries = Database.getInstance().getDeliveryList();
        List<Delivery> provider_deliveries = new ArrayList<>();
        for (Delivery dev : deliveries) {
            if (dev.getPackageDelivered().getProvider_id()==(provider_id)) {
                provider_deliveries.add(dev);
            }
        }
        return provider_deliveries;
    }

    @Override
    public Delivery getNextDelivery() {
        /******* TEST ******/
        // Database.getInstance().initializeDatabase();
       // System.out.println("Passage dans mon service");
        List<Delivery> deliveries = Database.getInstance().getDeliveryList();
        if (deliveries.size() !=0) {
            for (Delivery del : deliveries
            ) {
                if (!del.getStatus()) {
                    del.setStatus(true);
                    return del;
                }
            }
        }
        return null;
    }
}
