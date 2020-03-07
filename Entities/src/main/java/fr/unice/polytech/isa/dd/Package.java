package fr.unice.polytech.isa.dd;
import org.joda.time.DateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Package implements Serializable {

    @NotNull
    private String id;

    @NotNull
    private double weight;

    @NotNull
    private DateTime deliveryDate;

    @NotNull
    private String provider_id;

    public Package() {
        // Necessary for JPA instantiation process
    }

    public Package(String i,Double w,DateTime d, String pro_id) {
        id = i;
        weight = w;
        deliveryDate = d;
        provider_id = pro_id;
    }

    public double getWeight() {
        return weight;
    }

    public String getProvider_id() {
        return provider_id;
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
