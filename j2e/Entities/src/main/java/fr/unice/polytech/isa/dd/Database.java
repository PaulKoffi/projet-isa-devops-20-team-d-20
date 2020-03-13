package fr.unice.polytech.isa.dd;


import java.util.*;

public class Database {


    private List<Delivery> deliveryList;
    private List<Provider> providerList;


    private Database() {
        deliveryList = new ArrayList<>();
        providerList = new ArrayList<>();
    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }
}