package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.*;

import javax.ejb.EJB;
import java.util.List;
import java.util.Map;

public class BillingBean implements BillingGeneratedInterface,CheckTransferStatus {

    Database db = Database.getInstance();


    @EJB
    private DeliveryBean deliveryBean;

    private BankAPI bank;
    public BillingBean() { }
    @Override
    public void generateBill() {
        deliveryBean = new DeliveryBean();

        for (Map.Entry<Provider, List<Delivery>> entry : deliveryBean.getAllDayDeliveries().entrySet()) {
            // System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue().size());
            db.getBillList().add(new Bill(entry.getKey() , entry.getValue()));
        }
    }

    @Override
    public boolean checkstatut(String id) {
        return false;
    }
}
