package arquillian;

import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.*;

import fr.unice.polytech.isa.dd.entities.Package;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.joda.time.DateTime;

import javax.ejb.EJB;
import java.security.Provider;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBillingTest {

    @EJB
    protected Database database;
    @EJB(name = "delivery-stateless") protected NextDeliveryInterface nextDelivery ;
    @EJB(name = "bill-stateless") protected BillingGeneratedInterface billinggenerator ;

    protected List<Delivery> deliveries = Database.getInstance().getDeliveryList();
    protected List<fr.unice.polytech.isa.dd.entities.Provider> providers = Database.getInstance().getProviderList();
    protected List<Bill> bills = Database.getInstance().getBillList();
    protected Delivery del;

    @Deployment
    public static WebArchive createDeployement(){
        return ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml")
                .addPackage(Delivery.class.getPackage())
                .addPackage(DeliveryBean.class.getPackage())
                .addPackage(Customer.class.getPackage())
                .addPackage(Provider.class.getPackage())
                .addPackage(Database.class.getPackage())
                .addPackage(Package.class.getPackage())
                .addPackage(Bill.class.getPackage())
                .addPackage(BillingBean.class.getPackage())
                ;
    }



    public void initialiatizeFirstTest(int arg1, String arg2){
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        fr.unice.polytech.isa.dd.entities.Provider pro1 = new fr.unice.polytech.isa.dd.entities.Provider("1", arg2);
        providers.add(pro1);

        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
    }

    public void initializeDatabaseTestWithMutipleProviders(int arg1, String arg2,String arg3) {
        cleanDatabase();
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        fr.unice.polytech.isa.dd.entities.Provider pro1 = new fr.unice.polytech.isa.dd.entities.Provider("1", arg2);
        fr.unice.polytech.isa.dd.entities.Provider pro2 = new fr.unice.polytech.isa.dd.entities.Provider("2",arg3);
        providers.add(pro1);providers.add(pro2);

        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
        for (int i = 0; i < arg1; i++){
            deliveries.add(new Delivery(c,new Package(""+i*2,10.0,dt,pro2.getId()),dt,null));
        }
    }

    public void cleanDatabase(){
        providers.clear();
        deliveries.clear();
        bills.clear();
    }
}
