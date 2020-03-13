package fr.unice.polytech.isa.dd;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD:DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryBean.java
public class DeliveryBean implements DeliveryInterface, NextDeliveryInterface {
=======
@Stateless
public class DeliveryBean implements DeliveryInterface, NextDeliveryInterface {

>>>>>>> 3f87aa7e3330f867641231157a7eb2116bf6db12:j2e/DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryBean.java

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

<<<<<<< HEAD:DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryBean.java

    @Override
    public Delivery getNextDelivery() {
        for (Delivery del:deliveries
             ) {
            if(!del.getStatus()) return del;
=======
    @Override
    public Delivery getNextDelivery() {
        List<Delivery> deliveries = Database.getInstance().getDeliveryList();
        if(deliveries != null) {
            for (Delivery del : deliveries
            ) {
                if (!del.getStatus()) return del;
            }
>>>>>>> 3f87aa7e3330f867641231157a7eb2116bf6db12:j2e/DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryBean.java
        }
        return null;
    }
}
