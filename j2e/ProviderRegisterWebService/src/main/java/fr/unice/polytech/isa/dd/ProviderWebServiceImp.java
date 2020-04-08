package fr.unice.polytech.isa.dd;
import fr.unice.polytech.isa.dd.entities.Provider;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/providerService")
@Stateless(name = "ProviderWS")
public class ProviderWebServiceImp implements ProviderWebService {

    @EJB private ProviderFinder finder;
    @EJB private ProviderRegistration registry;

    @Override
    public Boolean register(String name){
        System.out.println("registerProvider");
        return registry.register(name);
    }

    @Override
    public Provider findProvider(String name){
        System.out.println("findProvider");
        return finder.findByName(name);
    }


}
