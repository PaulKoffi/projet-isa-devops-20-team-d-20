package fr.unice.polytech.isa.dd.entities;
import org.joda.time.DateTime;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

///@Embeddable
public class Package implements Serializable {

   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @NotNull
    private double weight;

//    @NotNull
    private DateTime deliveryDate;

//    @NotNull
    private int provider_id;

    public Package() {
        // Necessary for JPA instantiation process
    }

    public Package(int i,Double w,DateTime d, int pro_id) {
        id = i;
        weight = w;
        deliveryDate = d;
        provider_id = pro_id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(DateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /*** ecriture de la méthode hash à faire ****/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package that = (Package) o;
        return Objects.equals(id, that.id) && Double.compare(that.weight, weight) == 0;
    }

}
