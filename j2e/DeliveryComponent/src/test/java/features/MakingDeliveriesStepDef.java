package features;

import arquillian.AbstractDeliveryTest;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.DeliveryInterface;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Package;
import fr.unice.polytech.isa.dd.entities.Provider;
import io.cucumber.java8.Fr;
import io.cucumber.java8.PendingException;
import org.joda.time.DateTime;

import javax.ejb.EJB;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;


public class MakingDeliveriesStepDef extends AbstractDeliveryTest implements Fr {

    @EJB (name = "delivery-stateless") private NextDeliveryInterface nextDeliveryInterface;
    @EJB (name = "delivery-stateless") private DeliveryInterface deliveryInterface;
    @EJB (name = "database-stateless") private Database databaseTest = Database.getInstance();


    private List<Provider> providers = Database.getInstance().getProviderList();
    private List<Delivery> delivs = Database.getInstance().getDeliveryList();
    private Delivery delivery;

    public void initializeDatabaseDeliveryTest() {
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        Provider pro1 = new Provider("1", "Aug1");
        providers.add(pro1);

        Package pk1 = new Package("1", 2.0, dt, "1");

        Delivery d1 = new Delivery(c, pk1, dt, null);
        delivs.add(d1);

    }

    public void cleanDatabase(){
        for(Iterator<Provider> itpor = providers.iterator(); itpor.hasNext();){
            itpor.next();
            itpor.remove();
        }
        for(Iterator<Delivery> itdel = delivs.iterator();itdel.hasNext();){
            itdel.next();
            itdel.remove();
        }
    }

    @Quand("^l'employé demande la prochaine livraison$")
    public void lemployer_demande_la_prochaine_livraison()  {
        delivs = Database.getInstance().getDeliveryList();
    }
    @Alors("^Il y a (\\d+) livraisons$")
    public void il_y_a_livraisons(int arg1) {
        nextDeliveryInterface = new DeliveryBean();
        assertNull(nextDeliveryInterface.getNextDelivery());
    }

    @Quand("L'entreprise reçoit une livraison")
    public void lEntrepriseReçoitUneLivraison() {
        initializeDatabaseDeliveryTest();
        delivs =  databaseTest.getDeliveryList();
    }

    @cucumber.api.java.fr.Et("l'employé regarde la prochaine livraison")
    public void lEmployéRegardeLaProchaineLivraison() {
        nextDeliveryInterface = new DeliveryBean();
    }

    @Alors("Il devrait y avoir (\\d+) livraison")
    public void ilYLivraison(int arg0) {
        assertNotNull(nextDeliveryInterface.getNextDelivery());
        delivs.get(0).setStatus(true);
    }

    @Et("après il n'y a plus de livraisons")
    public void aprèsIlNYAPlusDeLivraisons() {
        assertNull(nextDeliveryInterface.getNextDelivery());
        cleanDatabase();
    }
}
