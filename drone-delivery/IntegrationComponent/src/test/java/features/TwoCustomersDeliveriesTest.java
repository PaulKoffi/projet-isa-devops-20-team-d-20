package features;

import arquillian.AbstractDroneDeliveryTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.runtime.arquillian.CukeSpace;
import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.Provider;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.runner.RunWith;
import utils.MyDate;

import javax.ejb.EJB;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(CukeSpace.class)
@CucumberOptions(features = "src/test/resources/features/TwoCustomerDeliveries.feature")
@Transactional(TransactionMode.COMMIT)
public class TwoCustomersDeliveriesTest extends AbstractDroneDeliveryTest {

    @EJB(name = "delivery-stateless") private DeliverySchedule deliverySchedule;
    @EJB(name = "delivery-stateless") private NextDeliveryInterface nextDeliveryInterface;
    @EJB(name = "package-stateless") private PackageRegistration packageRegistration;
    @EJB(name = "provider-stateless") private ProviderRegistration providerRegistration;
    @EJB(name = "package-stateless") private PackageFinder packageFinder;
    @EJB(name = "provider-stateless") private ProviderFinder providerFinder;
    @EJB(name = "planning-stateless") private AvailableSlotTime availableSlotTime;
    @EJB(name = "planning-stateless") private DeliveryRegistration deliveryRegistration;
    @EJB(name = "customer-stateless") private CustomerRegistration customerRegistration;
    @EJB(name = "customer-stateless") private CustomerFinder customerFinder;
    @EJB(name = "bill-stateless") private BillingGeneratedInterface billingGeneratedInterface;

    @Quand("^Un employé enregistre un colis de numéro (\\d+) de (\\d+)kg d'un fournisseur du nom de (.*)$")
    public void engistrepremiercolis(int arg0, int arg1, String arg3){
    }

    @Et("^un autre colis de numéro (\\d+) de (\\d+)kg d'un fournisseur de nom (.*)$")
    public void enregistresecondcolis(int arg0, int arg1,String arg2) throws Exception {
    }

    @Et("^un autre cois de numéro (\\d+) de (\\d+)kg du fournisseur (.*)$")
    public void enregitertroisiemecolis(int arg0, int arg1,String arg2) throws Exception {
    }

    @Quand("^un employé reçoit l'appel de madame (.*) (.*) résidant à l'adresse (.*)")
    public void appelpremierclient(String arg0) throws Exception {
    }

    @Et("^il vérifie si elle existe déjà dans le système et l'enregistre si ce n'est pas le cas$")
    public void enregistreoupas(int arg0, String arg1) throws Exception {
    }

    @Et("^à la demande du client enregistre une livraison le (.*) à (.*) pour le colis (\\d+)$")
    public void enregiterunelivraison(String arg0, String arg1,int arg2) throws Exception {
    }

    @Alors("^il y a (\\d+) colis à livrer$")
    public void nombredelivraisonafaire(Integer arg0) throws Exception {
    }

    @Quand("^l'employé reçoit l'appel de madame (.*)")
    public void reç(String arg0) throws Exception {
    }

    @Alors("^il remarque donc que cette dernière est dans le système$")
    public void existe() throws Exception {
    }

    @Et("^à sa demande, il enregistre une livraison le (.*) à (.*) pour le colis (\\d+)$")
    public void engliv(String arg0, String arg1,int arg2) throws Exception {
    }

    @Alors("^l'employé explique cela n'est pas possible$")
    public void impo(Integer arg0) throws Exception {
    }

    @Et("^donc la cliente reprogramme sa livraison pour le (.*) à (.*) pour le colis (\\d+)$")
    public void engliv1(String arg0, String arg1,int arg2) throws Exception {
    }

    @Alors("^il y a maintenant (\\d+) colis à livrer$")
    public void nbliv(Integer arg0) throws Exception {
    }

    @Quand("^l'employé est contacté par madame (.*) (.*) résidant à l'adresse (.*)$")
    public void reç(String arg0,String arg1, String arg2) throws Exception {
    }

    @Alors("^il constate qu'elle n'est pas dans le système et donc l'enregistre$")
    public void impo() throws Exception {
    }

    @Et("^cette dernière demande à être livrée le (.*) à (.*) pour le colis (\\d+)$")
    public void eng(String arg0, String arg1,int arg2) throws Exception {
    }

    @Alors("^l'employé lui dit que le colis n'existe pas$")
    public void notin() throws Exception {
    }

    @Alors("^elle change le numéro du colis en (\\d+)$")
    public void change(Integer arg0) throws Exception {
    }

    @Alors("^l'employé enregistre la livraison$")
    public void nbliv() throws Exception {
    }

    @Et("^il y a (\\d+) livraisons à effectuer$")
    public void engliv1(int arg0) throws Exception {
    }

    @Quand("^le (.*) l'employé demande la prochaine livraison$")
    public void nextliv1(String arg0) throws Exception {
    }

    @Alors("^il livre le colis au nuémro (\\d+)$")
    public void liv1(int arg0) throws Exception {
    }

    @Et("^il refait une autre demande$")
    public void engliv1() throws Exception {
    }
    @Et("^donc livre celui au numéro (\\d+)$")
    public void liv(int arg0) throws Exception {
    }

    @Quand("^Madame (.*) rappelle le (.*) pour reprogrammer sa livraison$")
    public void rapp(String arg0,String arg1) throws Exception {
    }

    @Alors("^elle donne la date du (.*) à (.*) de son colis (\\d+)$")
    public void newdate(String argg0,int arg1) throws Exception {
    }

    @Et("^l'employé reprogramme sa livraison$")
    public void reprog() throws Exception {
    }

    @Quand("^un employé génère les factures de la journées du (.*)$")
    public void finjour(String arg0) throws Exception {
    }

    @Alors("^il y a (\\d+) factures éditées$")
    public void nbfact(int arg0) throws Exception {
    }

    @Et("^(\\d+) pour le fournisseur AUG de (\\d+)€$")
    public void fact1(int arg0, int arg1) throws Exception {
    }
    @Et("^(\\d+) pour PAU de (\\d+)€$")
    public void fact2(int arg0,int arg1) throws Exception {
    }


    @Quand("^le (.*) on demande la prochaine livraison$")
    public void tpspaass(String arg0) throws Exception {
    }

    @Alors("^on livre celle au colis numéro (\\d+)$")
    public void liv2(int arg0) throws Exception {
    }

    @Et("^donc à la fin de la journée le fournisseur AUG a (\\d+) facture de (\\d+)€ à payer$")
    public void pr(int arg0, int arg1) throws Exception {
    }
}
