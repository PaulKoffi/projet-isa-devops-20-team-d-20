package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRegisterBeanTest {

    CustomerRegisterBean custRegister = new CustomerRegisterBean();

    @Test
    public void register() {

        Customer c = new Customer("Messan Aurore","03 Rue soutrane");
        custRegister.mydata.getCustomerList().add(c);
        assertEquals(1,custRegister.mydata.getCustomerList().size());
    }

    @Test
    public void findByName() {
        Customer c = new Customer("Amoussou Boris","03 Rue soutrane");
        custRegister.mydata.getCustomerList().add(c);
        Customer finder = custRegister.findByName("Amoussou Boris");
        assertEquals("Le client est trouvé",c,finder);

    }
}

