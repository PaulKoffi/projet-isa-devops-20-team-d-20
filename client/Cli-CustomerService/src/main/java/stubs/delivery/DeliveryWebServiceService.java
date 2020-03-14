package stubs.delivery;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2020-03-14T23:18:11.233+01:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "DeliveryWebServiceService", 
                  wsdlLocation = "file:/C:/Users/user/Desktop/SI4%20-%20S2/Isa-DevOps/new/projet-isa-devops-20-team-d-20/projet-isa-devops-20-team-d-20/client/Cli-CustomerService/src/main/resources/DeliveryWebService.wsdl",
                  targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService") 
public class DeliveryWebServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", "DeliveryWebServiceService");
    public final static QName DeliveryWebServicePort = new QName("http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", "DeliveryWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/user/Desktop/SI4%20-%20S2/Isa-DevOps/new/projet-isa-devops-20-team-d-20/projet-isa-devops-20-team-d-20/client/Cli-CustomerService/src/main/resources/DeliveryWebService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DeliveryWebServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/user/Desktop/SI4%20-%20S2/Isa-DevOps/new/projet-isa-devops-20-team-d-20/projet-isa-devops-20-team-d-20/client/Cli-CustomerService/src/main/resources/DeliveryWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DeliveryWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DeliveryWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeliveryWebServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public DeliveryWebServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DeliveryWebServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DeliveryWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns DeliveryWebService
     */
    @WebEndpoint(name = "DeliveryWebServicePort")
    public DeliveryWebService getDeliveryWebServicePort() {
        return super.getPort(DeliveryWebServicePort, DeliveryWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DeliveryWebService
     */
    @WebEndpoint(name = "DeliveryWebServicePort")
    public DeliveryWebService getDeliveryWebServicePort(WebServiceFeature... features) {
        return super.getPort(DeliveryWebServicePort, DeliveryWebService.class, features);
    }

}