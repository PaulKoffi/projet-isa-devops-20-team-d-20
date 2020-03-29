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

}
