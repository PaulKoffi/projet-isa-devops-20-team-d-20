package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Package;
import fr.unice.polytech.isa.dd.PackageFinder;
import fr.unice.polytech.isa.dd.PackageRegistration;
import fr.unice.polytech.isa.dd.entities.Provider;
import org.joda.time.DateTime;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/tcf/packages")
@Stateless(name = "PackageWS")
public class PackageRegisterWebServiceImp implements PackageRegisterWebService {

    @EJB private PackageFinder finder;
    @EJB private PackageRegistration registry;

    @Override
    public void register(int id, Double w, DateTime dt, Provider pro){
        registry.register(id, w, dt, pro);
    }

    @Override
    public Package findPackage(int id){
        return finder.findById(id);
    }


}
