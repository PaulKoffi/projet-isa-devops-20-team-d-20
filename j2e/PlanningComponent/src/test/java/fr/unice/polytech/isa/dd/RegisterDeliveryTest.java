package fr.unice.polytech.isa.dd;

import arquillian.AbstractPlanningTest;
import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Package;
import fr.unice.polytech.isa.dd.entities.Provider;
import gherkin.lexer.De;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class RegisterDeliveryTest extends AbstractPlanningTest {

    @EJB(name = "planning-stateless") DeliveryRegistration deliveryRegistration;
    @PersistenceContext
    private EntityManager entityManager;
    private Customer customer = new Customer("Paul","where does he live");
    private Provider provider = new Provider();
    private Package aPackage = new Package();

    @Test
    public void registertest(){
        entityManager.persist(customer);

        provider.setName("Aug");
        entityManager.persist(provider);

        aPackage.setWeight(10.0);
        aPackage.setProvider(provider);
        entityManager.persist(aPackage);
        provider.add(aPackage);

        deliveryRegistration.register_delivery("Paul","Aug");

        assertEquals(1,customer.getCustomer_deliveries().size());
    }
}
