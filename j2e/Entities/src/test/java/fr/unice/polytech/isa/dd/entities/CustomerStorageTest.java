package fr.unice.polytech.isa.dd.entities;

import arquillian.AbstractEntitiesTest;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
public class CustomerStorageTest extends AbstractEntitiesTest {

    @PersistenceContext(unitName = "dd_persistence_unit")
    private EntityManager entityManager;

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testCustomerStorage(){
        Customer customer = new Customer();
        customer.setName("Paul");
        customer.setAddress("i dont know");

        assertEquals(0,customer.getId());

        entityManager.persist(customer);
        int id = customer.getId();
        assertNotEquals(0,id);
        Customer stored = (Customer) entityManager.find(Customer.class, id);
        assertEquals(customer, stored);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testProviderStorage(){
        Provider provider = new Provider();
        provider.setName("Aug");
        entityManager.persist(provider);

        Package package1 = new Package();
        package1.setWeight(10.0);
        package1.setProvider(provider);
        entityManager.persist(package1);
        provider.add(package1);

        Package package2 = new Package();
        package2.setWeight(20.0);
        package2.setProvider(provider);
        entityManager.persist(package2);
        provider.add(package2);

        int idp1 = package1.getId();
        provider.getPackages().remove(package1);
        entityManager.remove(package1);

        assertNull(entityManager.find(Package.class, idp1));
        assertNotNull(entityManager.find(Package.class, package2.getId()));
        assertEquals(1, provider.getPackages().size());
        assertEquals(package2, provider.getPackages().toArray()[0]);
        assertEquals(provider, entityManager.find(Provider.class, provider.getId()));
    }

}
