package api;

import stubs.billing.BillingWebService;
import stubs.billing.BillingWebServiceService;
import stubs.delivery.DeliveryWebService;
import stubs.delivery.DeliveryWebServiceService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DDPublicAPI {

    public DeliveryWebService dws;
    public BillingWebService bws;


    public DDPublicAPI(String host, String port) {
        initBBS(host,port);
        initDDS(host, port);
    }

    private void initDDS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/DeliveryWebService.wsdl");
        DeliveryWebServiceService factory = new DeliveryWebServiceService(wsdlLocation);
        this.dws = factory.getDeliveryWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/DeliveryWS";
        ((BindingProvider) dws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initBBS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/BillingWebService.wsdl");
        BillingWebServiceService factory = new BillingWebServiceService(wsdlLocation);
        this.bws = factory.getBillingWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/BillingWS";
        ((BindingProvider) bws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
