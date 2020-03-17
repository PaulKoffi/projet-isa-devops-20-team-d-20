package arquillian;

import fr.unice.polytech.isa.dd.DeliveryBean;
import fr.unice.polytech.isa.dd.business.BillingBean;
import fr.unice.polytech.isa.dd.entities.*;

import fr.unice.polytech.isa.dd.entities.Package;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import javax.ejb.EJB;
import java.security.Provider;

public abstract class AbstractBillingTest {

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
                .addPackage(Bill.class.getPackage())
                .addPackage(BillingBean.class.getPackage())
                ;
    }
}
