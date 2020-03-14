
package stubs.delivery;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stubs.delivery package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNextDelivery_QNAME = new QName("http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", "getNextDelivery");
    private final static QName _GetNextDeliveryResponse_QNAME = new QName("http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", "getNextDeliveryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stubs.delivery
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNextDelivery }
     * 
     */
    public GetNextDelivery createGetNextDelivery() {
        return new GetNextDelivery();
    }

    /**
     * Create an instance of {@link GetNextDeliveryResponse }
     * 
     */
    public GetNextDeliveryResponse createGetNextDeliveryResponse() {
        return new GetNextDeliveryResponse();
    }

    /**
     * Create an instance of {@link Delivery }
     * 
     */
    public Delivery createDelivery() {
        return new Delivery();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Package }
     * 
     */
    public Package createPackage() {
        return new Package();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNextDelivery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", name = "getNextDelivery")
    public JAXBElement<GetNextDelivery> createGetNextDelivery(GetNextDelivery value) {
        return new JAXBElement<GetNextDelivery>(_GetNextDelivery_QNAME, GetNextDelivery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNextDeliveryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", name = "getNextDeliveryResponse")
    public JAXBElement<GetNextDeliveryResponse> createGetNextDeliveryResponse(GetNextDeliveryResponse value) {
        return new JAXBElement<GetNextDeliveryResponse>(_GetNextDeliveryResponse_QNAME, GetNextDeliveryResponse.class, null, value);
    }

}
