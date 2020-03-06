package fr.unice.polytech.isa.dd.Components;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.interfaces.CustomerFinder;
import fr.unice.polytech.isa.dd.interfaces.CustomerRegistration;

public class CustomerRegister implements CustomerRegistration, CustomerFinder {

    private String generateID(){
        //TODO
        return "";
    }

    @Override
    public void register(String customer_lastname, String customer_firstname, String customer_address) {
        //TODO

    }

    @Override
    public Customer findByName(String customer_name) {
        return null;
    }
}
