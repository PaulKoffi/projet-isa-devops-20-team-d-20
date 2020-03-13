package fr.unice.polytech.isa.dd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {


    private List<Delivery> deliveryList;
    private List<Customer> customerList;


    private Database() {
        customerList=new ArrayList<Customer>();
        deliveryList = new ArrayList<>();
    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Customer> getCustomerList() { return customerList; }
}