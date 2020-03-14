package fr.unice.polytech.isa.dd.entities;


import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Delivery> deliveryList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private List<Bill> billList;



    private Database() {
        customerList = new ArrayList<Customer>();
        deliveryList = new ArrayList<>();
        providerList = new ArrayList<>();
        billList = new ArrayList<>();
    }

    public void initializeDatabase() {
        Customer c = new Customer("Pm", "adresse1");
        customerList.add(c);

        DateTime dt = new DateTime();

        Provider pro1 = new Provider("1", "Aug1");
        Provider pro2 = new Provider("2", "Aug2");
        providerList.add(pro1);
        providerList.add(pro2);

        Package pk1 = new Package("1", 2.0, dt, "1");
        Package pk2 = new Package("2", 2.0, dt, "1");
        Package pk3 = new Package("3", 2.0, dt, "2");

        Delivery d1 = new Delivery(c, pk1, dt, null);
        Delivery d2 = new Delivery(c, pk2, dt, null);
        Delivery d3 = new Delivery(c, pk3, dt, null);
        deliveryList.add(d1);
        deliveryList.add(d2);
        deliveryList.add(d3);

    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public List<Bill> getBillList() { return billList; }
}