package fr.unice.polytech.isa.dd;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBean implements DeliveryInterface {

    List<Delivery> deliveries = new ArrayList<>() ;
    List<Delivery> provider_deliveries;

    public DeliveryBean(List<Delivery> devlivs){
        this.deliveries = devlivs;
        this.provider_deliveries = new ArrayList<>();
    }

    @Override
    public void getAllDayDeliveries(String provider_id) {

    }

    @Override
    public List<Delivery> getAllDeliveries(String provider_id) {
        for (Delivery dev:deliveries) {
            if(dev.getPackageDelivered().getProvider_id().equals(provider_id)){
                this.provider_deliveries.add(dev);
            }
        }
        return this.provider_deliveries;
    }

}
