package features;

import arquillian.AbstractBillingTest;
import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.DeliveryInterface;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.business.BillingBean;
import fr.unice.polytech.isa.dd.business.BillingGeneratedInterface;
import fr.unice.polytech.isa.dd.entities.Bill;
import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Provider;
import io.cucumber.java8.Fr;
import static org.junit.Assert.*;

import javax.ejb.EJB;
import java.util.List;

public class GeneratingBillsStepDefs extends AbstractBillingTest implements Fr {

    @EJB(name="nextdelivery-stateless") private NextDeliveryInterface nextDelivery = new DeliveryBean();
    @EJB(name = "delvery-stateless") private DeliveryInterface delivery = new DeliveryBean();
    @EJB(name = "bill-stateless") private BillingGeneratedInterface billinggenerator = new BillingBean();

    private List<Delivery> deliveries = Database.getInstance().getDeliveryList();
    private List<Provider> providers = Database.getInstance().getProviderList();
    private List<Bill> bills = Database.getInstance().getBillList();
    private Delivery del;


    public GeneratingBillsStepDefs() {
        Quand("^l'employé demande la prochaine livraison$", () -> {
            del = nextDelivery.getNextDelivery();
        });
        Alors("^il y (\\d+) livraisons$", (Integer arg0) -> {
            assertNull(del);
        });
        Et("^donc il y a (\\d+) facture$", (Integer arg0) -> {
            assertEquals(0,bills.size());
        });
        Quand("^l'employé effectue les (\\d+) prochaines livraisons$", (Integer arg0) -> {
        });
        Alors("^il y (\\d+) facture$", (Integer arg0) -> {
        });
    }
}
