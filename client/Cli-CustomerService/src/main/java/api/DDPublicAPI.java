package api;

import stubs.delivery.DeliveryWebService;
import stubs.delivery.DeliveryWebServiceService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DDPublicAPI {

    public DeliveryWebService dws;


    public DDPublicAPI(String host, String port) {
        initDDS(host, port);
    }
//
    private void initDDS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/DeliveryWebService.wsdl");
        DeliveryWebServiceService factory = new DeliveryWebServiceService(wsdlLocation);
        this.dws = factory.getDeliveryWebServicePort();
        String address = "http://" + host + ":" + port + "/DeliveryComponent/webservices/DeliveryWS";
        ((BindingProvider) dws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
