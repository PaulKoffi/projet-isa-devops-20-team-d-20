package fr.unice.polytech.isa.dd;
/*
import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.*;
import fr.unice.polytech.isa.dd.entities.Package;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.ejb.EJB;


import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class BillingBeanTest {


    @EJB private BillingGeneratedInterface bg = new BillingBean();
    @EJB private CheckTransferStatus ct = new BillingBean();

    private  List<Delivery> ds;
    Database db = Database.getInstance();
    private Provider p1;
    private Provider p2;
    private Bill b;




    @Before
    public void setUp() {
        db.clearDatabase();
        Customer c = new Customer("Doni","10 rue des lucioles");
        DateTime d = new DateTime();
        p1 = new Provider("1","p1");
        p2 = new Provider("2","p2");
        db.getProviderList().add( p1);
        db.getProviderList().add( p2);
        Package package1 = new Package("1",2.0,d,"1");
        Delivery d1 = new Delivery(c,package1,d,null) ;
        d1.setStatus(true);
        db.getDeliveryList().add(d1);
        ds = new ArrayList<>();
        ds.add(d1);
        b = new Bill(1,p1, ds);
    }

    @Test
    public void GenerateBillTest() {

        bg.generateBill();
        //DeliveryBean d = new DeliveryBean();
        assertEquals(1, db.getBillList().size());
        assertEquals(b.getProvider(), db.getBillList().get(0).getProvider());
        assertEquals(b.getDeliveries().get(0), db.getBillList().get(0).getDeliveries().get(0));

    }

    @Test
    public void checkstatutTest( )
    {
        bg.generateBill();
        assertTrue(ct.checkstatut(1));
        assertFalse(ct.checkstatut(2));
    }

    @Test
    public void getAllPaidBillsTest() throws ExternalPartnerException {
        bg.generateBill();
        db.getBillList().get(0).setId(1);
        assertEquals(1, ct.getAllPaidBills().size());
    }
}*/