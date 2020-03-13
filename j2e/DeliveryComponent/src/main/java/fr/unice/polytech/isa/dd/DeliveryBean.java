package fr.unice.polytech.isa.dd;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DeliveryBean implements DeliveryInterface, NextDeliveryInterface {


    List<Delivery> provider_deliveries;

    public DeliveryBean(){
        this.provider_deliveries = new ArrayList<>();
    }

    @Override
    public void getAllDayDeliveries(String provider_id) {

    }

    @Override
    public List<Delivery> getAllDeliveries(String provider_id) {
        List<Delivery> deliveries = Database.getInstance().getDeliveryList();
        for (Delivery dev:deliveries) {
            if(dev.getPackageDelivered().getProvider_id().equals(provider_id)){
                this.provider_deliveries.add(dev);
            }
        }
        return this.provider_deliveries;
    }

    @Override
    public Delivery getNextDelivery() {
        List<Delivery> deliveries = Database.getInstance().getDeliveryList();
        if(deliveries != null) {
            for (Delivery del : deliveries
            ) {
                if (!del.getStatus()) return del;
            }
        }
        return null;
    }
}
