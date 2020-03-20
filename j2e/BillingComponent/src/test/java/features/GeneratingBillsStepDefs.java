package features;

import arquillian.AbstractBillingTest;
import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.DeliveryInterface;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.BillingBean;
import fr.unice.polytech.isa.dd.BillingGeneratedInterface;
import fr.unice.polytech.isa.dd.entities.*;
import fr.unice.polytech.isa.dd.entities.Package;
import io.cucumber.java8.Fr;
import org.joda.time.DateTime;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;

public class GeneratingBillsStepDefs extends AbstractBillingTest implements Fr {

    @EJB(name="nextdelivery-stateless") private NextDeliveryInterface nextDelivery = new DeliveryBean();
    @EJB(name = "delvery-stateless") private DeliveryInterface delivery = new DeliveryBean();
    @EJB(name = "bill-stateless") private BillingGeneratedInterface billinggenerator = new BillingBean();

    private List<Delivery> deliveries = Database.getInstance().getDeliveryList();
    private List<Provider> providers = Database.getInstance().getProviderList();
    private List<Bill> bills = Database.getInstance().getBillList();
    private Delivery del;

    public void initialiatizeFirstTest(int arg1, String arg2){
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        Provider pro1 = new Provider("1", arg2);
        providers.add(pro1);

        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
    }

    public void initializeDatabaseTestWithMutipleProviders(int arg1, String arg2,String arg3) {
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        Provider pro1 = new Provider("1", arg2);
        Provider pro2 = new Provider("2",arg3);
        providers.add(pro1);providers.add(pro2);

        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i*2,10.0,dt,pro2.getId()),dt,null));
        }
    }

    public void cleanDatabase(){
        for(Iterator<Provider> itpor = providers.iterator(); itpor.hasNext();){
            itpor.next();
            itpor.remove();
        }
        for(Iterator<Delivery> itdel = deliveries.iterator();itdel.hasNext();){
            itdel.next();
            itdel.remove();
        }
        for (Iterator<Bill> itbill = bills.iterator();itbill.hasNext();){
            itbill.next();
            itbill.remove();
        }
    }

    public GeneratingBillsStepDefs() {
        Quand("^l'employé demande la prochaine livraison$", () -> {
//            Database.getInstance().clearDatabase();
            del = nextDelivery.getNextDelivery();
        });
        Alors("^il y a (\\d+) livraisons$", (Integer arg0) -> {
            assertNull(del);
        });
        Et("^donc il y a (\\d+) facture$", (Integer arg0) -> {
            billinggenerator.generateBill();
            assertEquals(arg0.intValue(),bills.size());
            cleanDatabase();
        });
        Quand("^l'employé effectue les (\\d+) prochaines livraisons du fournisseur (.*)$", (Integer arg0, String arg1) -> {
            initialiatizeFirstTest(arg0,arg1);
            for(int i = 0; i < arg0; i++){
                del = nextDelivery.getNextDelivery();
            }
        });
        Alors("^il y a (\\d+) facture$", (Integer arg0) -> {
            billinggenerator.generateBill();
            assertEquals(arg0.intValue(),bills.size());
            cleanDatabase();
        });
        Quand("^l'employé envoie les (\\d+) livraisons du fournisseurs (.*) et (.*)$", (Integer arg0,String arg1,String arg2) -> {
            initializeDatabaseTestWithMutipleProviders(arg0,arg1,arg2);
            del = nextDelivery.getNextDelivery();
//            System.out.println("etat de del " + (del == null));
            while(del != null){
                del = nextDelivery.getNextDelivery();
            }
        });
        Alors("^(\\d+) factures sont générées$", (Integer arg0) -> {
            billinggenerator.generateBill();
            assertEquals(arg0.intValue(),Database.getInstance().getBillList().size());
            cleanDatabase();
        });

    }
}
