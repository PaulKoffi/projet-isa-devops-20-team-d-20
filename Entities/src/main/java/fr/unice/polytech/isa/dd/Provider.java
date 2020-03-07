package fr.unice.polytech.isa.dd;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Provider implements Serializable {

    @NotNull
    private String id;

    @NotNull
    private String name;

    private Set<Package> packages = new HashSet<>();


    public Provider() {
        // Necessary for JPA instantiation process
    }

    public Provider(String i,String n) {
        id = i;
        name = n;
    }

    public void add(Package p) { this.packages.add(p); }

    public Set<Package> getPackages() { return packages; }

    /*** ecriture de la méthode hash + equals à faire ****/

}
