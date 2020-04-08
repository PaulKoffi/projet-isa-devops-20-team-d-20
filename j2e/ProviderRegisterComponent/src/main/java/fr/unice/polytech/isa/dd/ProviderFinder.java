package fr.unice.polytech.isa.dd;
import fr.unice.polytech.isa.dd.entities.Provider;
import javax.ejb.Local;

@Local
public interface ProviderFinder {
    Provider findByName(String provider_name);
}
