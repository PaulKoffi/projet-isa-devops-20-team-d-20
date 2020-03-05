package fr.unice.polytech.isa.dd.interfaces;

import fr.unice.polytech.isa.dd.entities.Customer;

public interface CustomerFinder {

    public Customer findByName(String customer_name);
}
