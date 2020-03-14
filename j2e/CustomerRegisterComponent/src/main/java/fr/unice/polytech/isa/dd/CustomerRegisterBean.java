package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Database;

public class CustomerRegisterBean implements CustomerRegistration, CustomerFinder {

    Database mydata = Database.getInstance();

    @Override
    public void register(String customer_lastname, String customer_firstname, String customer_address) {
        //TODO
        Customer customer = new Customer(customer_firstname+" "+customer_lastname,customer_address);
        //listcutomer.add(customer);
    }


    @Override
    public Customer findByName(String customer_name) {
        Customer c = new Customer();
        for (Customer customer: mydata.getCustomerList()
        ) {
            if(customer.getName().equals(customer_name)){
                System.out.println(customer.getId());
                c=customer;
            }
        }
        return c;
    }
}
