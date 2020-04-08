package features;

import arquillian.AbstractBillingTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.runtime.arquillian.CukeSpace;
import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.*;
import fr.unice.polytech.isa.dd.entities.Package;
import io.cucumber.java8.Fr;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.joda.time.DateTime;
import org.junit.runner.RunWith;
import utils.Init;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(CukeSpace.class)
@CucumberOptions(features = "src/test/resources/")
@Transactional(TransactionMode.COMMIT)
public class GeneratingBillsArquillianTest extends AbstractBillingTest implements Fr {

    @PersistenceContext private EntityManager entityManager;
    @Inject
    private UserTransaction utx;

    @EJB(name = "delivery-stateless") private NextDeliveryInterface nextDelivery ;
    @EJB(name = "bill-stateless") private BillingGeneratedInterface billinggenerator ;
    @EJB(name = "bill-stateless") private CheckTransferStatus checkTransferStatus;
    @EJB(name = "delivery-stateless") private DeliverySchedule deliverySchedule;
    @EJB(name = "delivery-stateless") private DeliveryInterface deliveryInterface;
    Provider pro1;
    Package package1;
    Delivery delivery1;


    //private HashMap<Provider,List<Delivery>> providerListHashMap;

    @Quand("^l'employé demande la prochaine livraison$")
    public void demandeprochainelivraison(){
        //init.cleanDatabase();
//      Database.getInstance().clearDatabase();
    }
    @Alors("^il y a (\\d+) livraisons$")
    public void ilyanombredelivraison(Integer arg0){
        assertNull(nextDelivery.getNextDelivery());
    }
    @Et("^donc il y a (\\d+) facture$")
    public void nombredefactures(Integer arg0){
        //billinggenerator.generateBill();
        //assertEquals(arg0.intValue(),billinggenerator.get_bills().size());
    }
    @Quand("^l'employé effectue les (\\d+) prochaines livraisons du fournisseur (.*)$")
    public void efftecueprochainelivraisons(Integer arg0, String arg1){
        /*init.initialiatizeFirstTest(arg0,arg1);
        for(int i = 0; i < arg0; i++){
            Delivery delivery = nextDelivery.getNextDelivery();
        }*/
        Customer c = new Customer("Doni","10 rue des lucioles");
        entityManager.persist(c);
        pro1 = new Provider();
        pro1.setName(arg1);
        entityManager.persist(pro1);

        package1 = new Package();
        package1.setWeight(10.0);
        package1.setProvider(pro1);
        entityManager.persist(package1);

        Delivery delivery1 = new Delivery();
        delivery1.setCustomer(c);
        delivery1.setPackageDelivered(package1);
        entityManager.persist(delivery1);
        Delivery delivery = nextDelivery.getNextDelivery();

        /*List<Delivery> deliveries1 = new ArrayList<>();
        deliveries1.add(delivery1);
        Bill bill = new Bill();
        bill.setDeliveries(deliveries1);
        bill.setProvider(pro1);
        entityManager.persist(bill);
        pro1.add(bill);*/
    }
    @Alors("^il y a (\\d+) facture$")
    public void facturenombre(Integer arg0) {
        billinggenerator.generateBill();
       // System.out.println("/*********************************\n"+billinggenerator.get_bills().size()+"***********************/");
        assertEquals(arg0.intValue(),billinggenerator.get_bills().size());
    }
    @Quand("^l'employé envoie les (\\d+) livraisons du fournisseurs (.*) et (.*)$")
    public void livraisonsenvoyées(Integer arg0,String arg1,String arg2){
       /* init.initializeDatabaseTestWithMutipleProviders(arg0,arg1,arg2);

        for(int i= 0; i < init.getDeliveries().size();i++){
            Delivery delivery = nextDelivery.getNextDelivery();
        }*/
        Customer c = new Customer("Pm", "adresse1");
        entityManager.persist(c);

        Provider pro3 = new Provider();
        pro3.setName(arg1);
        entityManager.persist(pro3);

        Provider pro2 = new Provider();
        pro2.setName(arg2);
        entityManager.persist(pro2);

        Package package5 = new Package();
        package5.setWeight(10.0);
        package5.setProvider(pro3);
        entityManager.persist(package5);


        Package package2 = new Package();
        package2.setWeight(15.0);
        package2.setProvider(pro3);
        entityManager.persist(package2);
        pro3.add(package5);
        pro3.add(package2);

        Delivery delivery1 = new Delivery();
        delivery1.setCustomer(c);
        delivery1.setPackageDelivered(package5);
        entityManager.persist(delivery1);

        Delivery delivery2 = new Delivery();
        delivery2.setCustomer(c);
        delivery2.setPackageDelivered(package2);
        entityManager.persist(delivery2);

        Package package3 = new Package();
        package3.setWeight(20.0);
        package3.setProvider(pro2);
        entityManager.persist(package3);


        Package package4 = new Package();
        package4.setWeight(25.0);
        package4.setProvider(pro2);
        entityManager.persist(package4);
        pro2.add(package3);
        pro2.add(package4);

        Delivery delivery3 = new Delivery();
        delivery3.setCustomer(c);
        delivery3.setPackageDelivered(package3);
        entityManager.persist(delivery3);

        Delivery delivery4 = new Delivery();
        delivery4.setCustomer(c);
        delivery4.setPackageDelivered(package4);
        entityManager.persist(delivery4);


        for(int i= 0; i < 3;i++){
            Delivery delivery = nextDelivery.getNextDelivery();
        }
/*
        for(Provider provider : deliverySchedule.providerList()){
            System.out.println("\n\n/**********************\n"+provider.getName()+" - "+provider.getId()+"\n****************************\n\n");
        }
       /* providerListHashMap = deliveryInterface.getAllDayDeliveries();
        for (Map.Entry<Provider, List<Delivery>> entry : providerListHashMap.entrySet()
             ) {
            System.out.println("\n\n/**********************\n"+entry.getKey().getName()+"\n****************************\n\n");
        }*/

    }
    //Ce test bug parce que la valeur doit être 2
    @Alors("^(\\d+) factures sont générées$")
    public void facturegenerees(Integer arg0){
        billinggenerator.generateBill();
        assertEquals(arg0.intValue(),billinggenerator.get_bills().size());
    }
}
