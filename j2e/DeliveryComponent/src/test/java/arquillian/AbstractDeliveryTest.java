package arquillian;

import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Database;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Package;
import org.apache.openejb.jee.Web;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import javax.ejb.EJB;
import java.security.Provider;

public abstract class AbstractDeliveryTest {

    @EJB
    protected Database database;

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
}
