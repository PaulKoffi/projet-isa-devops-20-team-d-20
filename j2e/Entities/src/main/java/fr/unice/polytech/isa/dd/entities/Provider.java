package fr.unice.polytech.isa.dd.entities;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "provider")
    private Set<Package> packages = new HashSet<>();


    public Provider() {
        // Necessary for JPA instantiation process
    }

    public Provider(int i,String n) {
        id = i;
        name = n;
    }

    public void add(Package p) { this.packages.add(p); }

    public Set<Package> getPackages() { return packages; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    /*** ecriture de la méthode hash + equals à faire ****/

}
