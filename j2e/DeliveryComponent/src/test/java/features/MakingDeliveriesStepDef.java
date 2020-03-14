package features;

import arquillian.AbstractDeliveryTest;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.DeliveryInterface;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Provider;
import io.cucumber.java8.Fr;
import io.cucumber.java8.PendingException;;import javax.ejb.EJB;
import static org.junit.Assert.*;

import java.util.List;


public class MakingDeliveriesStepDef extends AbstractDeliveryTest implements Fr {

    @EJB (name = "delivery-stateless") private NextDeliveryInterface nextDeliveryInterface;
    @EJB (name = "delivery-stateless") private DeliveryInterface deliveryInterface;

    private List<Provider> providers;
    private List<Delivery> delivs;
    private Delivery delivery;
    /*public MakingDeliveriesStepDef() {
        Etantdonné("^un employe soccupe deffecuter les livraisons",() ->{

        });
        */
        @Quand("^lemployer demande la prochaine livraison$")
        public void lemployer_demande_la_prochaine_livraison()  {
            // Write code here that turns the phrase above into concrete actions
            delivs = Database.getInstance().getDeliveryList();
        }
        @Alors("^Il y a (\\d+) livraisons$")
        public void il_y_a_livraisons(int arg1) {
            nextDeliveryInterface = new DeliveryBean();
            System.out.println(nextDeliveryInterface.getNextDelivery());
            assertNull(nextDeliveryInterface.getNextDelivery());
        }
        /*Quand("^lemployer demande la prochaine livraison$", () -> {


        });
        Alors("^Il y a (\\d+) livraisons$", (Integer arg0) -> {
            delivery = nextDeliveryInterface.getNextDelivery();
            assertNull(delivery);
        });*/
   // }
}
