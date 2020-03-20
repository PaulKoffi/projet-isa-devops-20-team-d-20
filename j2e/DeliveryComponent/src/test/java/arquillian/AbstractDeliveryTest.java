package arquillian;

import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.DeliveryInterface;
import fr.unice.polytech.isa.dd.NextDeliveryInterface;
import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Package;
import org.apache.openejb.jee.Web;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.joda.time.DateTime;

import javax.ejb.EJB;
import java.security.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDeliveryTest {

    @EJB
    protected Database database;

    @EJB (name = "delivery-stateless") protected NextDeliveryInterface nextDeliveryInterface;
    @EJB (name = "delivery-stateless") protected DeliveryInterface deliveryInterface;
    @EJB (name = "database-stateless") protected Database databaseTest = Database.getInstance();

    protected List<fr.unice.polytech.isa.dd.entities.Provider> providers = Database.getInstance().getProviderList();
    protected List<Delivery> delivs = Database.getInstance().getDeliveryList();
    protected Delivery delivery;
    protected HashMap<fr.unice.polytech.isa.dd.entities.Provider,List<Delivery>> providerListHashMap;

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
                ;
    }
    public void cleanDatabase(){
        providers.clear();
        delivs.clear();
    }

    public void initializeDatabaseDeliveryTest() {
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        fr.unice.polytech.isa.dd.entities.Provider pro1 = new fr.unice.polytech.isa.dd.entities.Provider("1", "Aug1");
        providers.add(pro1);

        Package pk1 = new Package("1", 2.0, dt, "1");

        Delivery d1 = new Delivery(c, pk1, dt, null);
        delivs.add(d1);

    }
    public void initializeDatabaseDeliveryTestWithParam(int arg1, String arg2) {
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        fr.unice.polytech.isa.dd.entities.Provider pro1 = new fr.unice.polytech.isa.dd.entities.Provider("1", arg2);
        providers.add(pro1);

        for (int i = 0; i < arg1; i++){
            delivs.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
    }
    public void initializeDatabaseDeliveryTestWithMutipleProviders(int arg1, String arg2,String arg3) {
        Customer c = new Customer("Pm", "adresse1");

        DateTime dt = new DateTime();

        fr.unice.polytech.isa.dd.entities.Provider pro1 = new fr.unice.polytech.isa.dd.entities.Provider("1", arg2);
        fr.unice.polytech.isa.dd.entities.Provider pro2 = new fr.unice.polytech.isa.dd.entities.Provider("2",arg3);
        providers.add(pro1);providers.add(pro2);

        for (int i = 0; i < arg1; i++){
            delivs.add(new Delivery(c,new Package(""+i,10.0,dt,pro1.getId()),dt,null));
        }
        for (int i = 0; i < arg1; i++){
            delivs.add(new Delivery(c,new Package(""+i*2,10.0,dt,pro2.getId()),dt,null));
        }
    }
}
