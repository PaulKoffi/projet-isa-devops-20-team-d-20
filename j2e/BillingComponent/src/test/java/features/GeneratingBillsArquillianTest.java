package features;

import arquillian.AbstractBillingTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.runtime.arquillian.CukeSpace;
import fr.unice.polytech.isa.dd.BillingGeneratedInterface;
import fr.unice.polytech.isa.dd.CheckTransferStatus;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.entities.Delivery;
import io.cucumber.java8.Fr;
import org.apache.cxf.feature.Features;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import utils.Init;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(CukeSpace.class)
@CucumberOptions(features = "src/test/resources")
public class GeneratingBillsArquillianTest extends AbstractBillingTest implements Fr {

    private Init init = new Init();
    @EJB(name = "delivery-stateless") private NextDeliveryInterface nextDelivery ;
    @EJB(name = "bill-stateless") private BillingGeneratedInterface billinggenerator ;
    @EJB(name = "bill-stateless") private CheckTransferStatus checkTransferStatus;

    @Quand("^l'employé demande la prochaine livraison$")
    public void demandeprochainelivraison(){
        init.cleanDatabase();
//      Database.getInstance().clearDatabase();
    }
    @Alors("^il y a (\\d+) livraisons$")
    public void ilyanombredelivraison(Integer arg0){
        assertNull(nextDelivery.getNextDelivery());
    }
    @Et("^donc il y a (\\d+) facture$")
    public void nombredefactures(Integer arg0){
        billinggenerator.generateBill();
        assertEquals(arg0.intValue(),init.getBills().size());
        init.cleanDatabase();
    }
    @Quand("^l'employé effectue les (\\d+) prochaines livraisons du fournisseur (.*)$")
    public void efftecueprochainelivraisons(Integer arg0, String arg1){
        init.initialiatizeFirstTest(arg0,arg1);
        for(int i = 0; i < arg0; i++){
            Delivery delivery = nextDelivery.getNextDelivery();
        }
    }
    @Alors("^il y a (\\d+) facture$")
    public void facturenombre(Integer arg0) {
        billinggenerator.generateBill();
        assertEquals(arg0.intValue(),init.getBills().size());
        init.cleanDatabase();
    }
    @Quand("^l'employé envoie les (\\d+) livraisons du fournisseurs (.*) et (.*)$")
    public void livraisonsenvoyées(Integer arg0,String arg1,String arg2){
        init.initializeDatabaseTestWithMutipleProviders(arg0,arg1,arg2);

        for(int i= 0; i < init.getDeliveries().size();i++){
            Delivery delivery = nextDelivery.getNextDelivery();
        }
    }
    //Ce test bug parce que la valeur doit être 2
    @Alors("^(\\d+) factures sont générées$")
    public void facturegenerees(Integer arg0){
        billinggenerator.generateBill();
        assertEquals(arg0.intValue(),init.getBills().size());
        init.cleanDatabase();
    }
}
