package fr.unice.polytech.isa.dd.business;

import fr.unice.polytech.isa.dd.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BillingBean implements BillingGeneratedInterface {


    Database db = Database.getInstance();

    @EJB private DeliveryBean deliveryBean;

    public BillingBean() { }

    @Override
    public void generateBill() {
        deliveryBean = new DeliveryBean();

        for (Map.Entry<Provider, List<Delivery>> entry : deliveryBean.getAllDayDeliveries().entrySet()) {
           // System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue().size());
            db.getBillList().add(new Bill(entry.getKey() , entry.getValue()));
        }
    }

}
