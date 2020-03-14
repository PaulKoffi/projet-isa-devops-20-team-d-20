
package stubs.delivery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour delivery complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="delivery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customer" type="{http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService}customer" minOccurs="0"/&gt;
 *         &lt;element name="customerMark" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deliveryDate" type="{http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="packageDelivered" type="{http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService}package" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "delivery", propOrder = {
    "beginTime",
    "customer",
    "customerMark",
    "deliveryDate",
    "endTime",
    "id",
    "packageDelivered",
    "price",
    "status"
})
public class Delivery {

    protected String beginTime;
    protected Customer customer;
    protected int customerMark;
    protected DateTime deliveryDate;
    protected String endTime;
    protected int id;
    protected Package packageDelivered;
    protected double price;
    protected boolean status;

    /**
     * Obtient la valeur de la propriété beginTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Définit la valeur de la propriété beginTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginTime(String value) {
        this.beginTime = value;
    }

    /**
     * Obtient la valeur de la propriété customer.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Définit la valeur de la propriété customer.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Obtient la valeur de la propriété customerMark.
     * 
     */
    public int getCustomerMark() {
        return customerMark;
    }

    /**
     * Définit la valeur de la propriété customerMark.
     * 
     */
    public void setCustomerMark(int value) {
        this.customerMark = value;
    }

    /**
     * Obtient la valeur de la propriété deliveryDate.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Définit la valeur de la propriété deliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setDeliveryDate(DateTime value) {
        this.deliveryDate = value;
    }

    /**
     * Obtient la valeur de la propriété endTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Définit la valeur de la propriété endTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété packageDelivered.
     * 
     * @return
     *     possible object is
     *     {@link Package }
     *     
     */
    public Package getPackageDelivered() {
        return packageDelivered;
    }

    /**
     * Définit la valeur de la propriété packageDelivered.
     * 
     * @param value
     *     allowed object is
     *     {@link Package }
     *     
     */
    public void setPackageDelivered(Package value) {
        this.packageDelivered = value;
    }

    /**
     * Obtient la valeur de la propriété price.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Définit la valeur de la propriété price.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

}
