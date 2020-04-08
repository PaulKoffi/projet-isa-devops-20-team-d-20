package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.CustomerFinder;
import fr.unice.polytech.isa.dd.CustomerRegistration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/customerService")
@Stateless(name = "CustomerWS")
public class CustomerWebServiceImp implements CustomerWebService {

    @EJB private CustomerFinder finder;
    @EJB private CustomerRegistration registry;

    @Override
    public Boolean register(String firstName,String lastName,String adress){
        System.out.println("registerCustomer");
        return registry.register(firstName,lastName,adress);
    }

    @Override
    public Customer findCustomer(String name){
        System.out.println("findCustomer");
        return finder.findByName(name);
    }


}
