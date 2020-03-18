package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.*;
import org.apache.cxf.common.i18n.UncheckedException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingBean implements BillingGeneratedInterface,CheckTransferStatus {

    Database db = Database.getInstance();
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @EJB private DeliveryInterface delivery = new DeliveryBean();

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
            JSONObject resp= bank.getPayment(id);
            double amount = resp.getDouble("Amount");
            status = true;
            //TODO
            //Must also update the paymentDate  with the date of the transfer and paymentStatus attribute after checking the amount of the transfer of the bill in database
            Bill b= findBillById(id);
            if ( (b != null)) {
                b.setBillStatus("PAID");
            }

        } catch (ExternalPartnerException e) {
            log.log(Level.INFO, "Error while exchanging with external partner", e);
        }
        return(status);
    }

    @Override
    public List<Bill> getAllPaidBills() throws ExternalPartnerException {
        List<Bill> bills = new ArrayList<>();
        JSONArray res = bank.getPayements();
        for (int i=0; i<res.length(); i++) {
            Bill b = findBillById(res.getInt(i));
            if (b != null) {
                b.setBillStatus("PAID");
              //  System.out.println(b.getBillStatus());
                bills.add(b);
            }
        }
        return bills;
    }

    public Bill findBillById(int id) {
        for (Bill b: db.getBillList()) {
            if (b.getId() ==id) {
                return b;
            }
        }
        return null;
    }
}

