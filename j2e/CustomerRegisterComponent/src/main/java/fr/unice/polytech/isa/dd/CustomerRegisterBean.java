package fr.unice.polytech.isa.dd;

public class CustomerRegisterBean implements CustomerRegistration, CustomerFinder {

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
