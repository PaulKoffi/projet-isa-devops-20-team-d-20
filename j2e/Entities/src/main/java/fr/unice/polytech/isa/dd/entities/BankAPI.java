package fr.unice.polytech.isa.dd.entities;


import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

public class BankAPI {

    private String url;

    public BankAPI(String host, String port) {
        this.url = "http://" + host + ":" + port;
    }

    public BankAPI() { this("localhost", "9090"); }

    public boolean performPayment(String id) throws ExternalPartnerException {
        JSONObject payment;
        try {
            String response = WebClient.create(url).path("/payments/" + id).get(String.class);
            if (response != null) {
                payment = new JSONObject(response);
                return true;
            }
        } catch (Exception e) {
            throw new ExternalPartnerException(url + "payments/" + id, e);
        }
        // Assessing the payment status
        //return (payment.getInt("Status") == 0);
        return false;
    }

}
