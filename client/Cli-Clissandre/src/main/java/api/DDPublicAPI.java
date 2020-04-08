package api;

import stubs.customer.CustomerWebService;
import stubs.customer.CustomerWebServiceService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DDPublicAPI {

    public CustomerWebService cws;


    public DDPublicAPI(String host, String port) {
        initCWS(host, port);
    }

    private void initCWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/CustomerWebService.wsdl");
        CustomerWebServiceService factory = new CustomerWebServiceService(wsdlLocation);
        this.cws = factory.getCustomerWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/CustomerWS";
        ((BindingProvider) cws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
