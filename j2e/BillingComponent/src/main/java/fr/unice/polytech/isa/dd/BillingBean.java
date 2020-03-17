package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.*;
import org.apache.cxf.common.i18n.UncheckedException;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingBean implements BillingGeneratedInterface,CheckTransferStatus {

    Database db = Database.getInstance();
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @EJB
    private DeliveryBean deliveryBean;

    private BankAPI bank;
    public BillingBean() {bank=new BankAPI(); }
    @Override
    public void generateBill() {
        deliveryBean = new DeliveryBean();

        for (Map.Entry<Provider, List<Delivery>> entry : deliveryBean.getAllDayDeliveries().entrySet()) {
            // System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue().size());
            db.getBillList().add(new Bill(entry.getKey() , entry.getValue()));
        }
    }

    @Override
    public boolean checkstatut(int id) {
        boolean status=false ;
        try {
            //System.out.println(bank.performPayment(id));
            JSONObject resp= bank.performPayment(id);
            status = true;

        } catch (ExternalPartnerException e) {
            log.log(Level.INFO, "Error while exchanging with external partner", e);
        }
        return(status);
    }



}
