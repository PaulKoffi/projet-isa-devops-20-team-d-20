package fr.unice.polytech.isa.dd;

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
            if(customer.getName()==customer_name){
                c=customer;
            }
        }
        return c;
    }
}
