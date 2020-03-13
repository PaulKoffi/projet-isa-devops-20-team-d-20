
package stubs.delivery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getNextDeliveryResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getNextDeliveryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="the_next_delivery" type="{http://www.polytech.unice.fr/si/4a/isa/dd/delivery}delivery" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNextDeliveryResponse", propOrder = {
    "theNextDelivery"
})
public class GetNextDeliveryResponse {

    @XmlElement(name = "the_next_delivery")
    protected Delivery theNextDelivery;

    /**
     * Obtient la valeur de la propriété theNextDelivery.
     * 
     * @return
     *     possible object is
     *     {@link Delivery }
     *     
     */
    public Delivery getTheNextDelivery() {
        return theNextDelivery;
    }

    /**
     * Définit la valeur de la propriété theNextDelivery.
     * 
     * @param value
     *     allowed object is
     *     {@link Delivery }
     *     
     */
    public void setTheNextDelivery(Delivery value) {
        this.theNextDelivery = value;
    }

}
