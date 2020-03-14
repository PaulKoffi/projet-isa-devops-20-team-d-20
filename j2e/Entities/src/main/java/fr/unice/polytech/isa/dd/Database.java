package fr.unice.polytech.isa.dd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {


    private List<Delivery> deliveryList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private List<Bill> billList;


    private Database() {
        customerList=new ArrayList<Customer>();
        deliveryList = new ArrayList<>();
        providerList = new ArrayList<>();
        billList = new ArrayList<>();
    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Customer> getCustomerList() { return customerList; }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public List<Bill> getBillList() { return billList; }

    public void addBills(Bill b) {
        billList.add(b);
    }
}