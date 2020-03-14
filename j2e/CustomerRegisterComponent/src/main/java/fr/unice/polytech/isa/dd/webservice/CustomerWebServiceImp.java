package fr.unice.polytech.isa.dd.webservice;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.CustomerFinder;
import fr.unice.polytech.isa.dd.CustomerRegistration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/tcf/customers")
@Stateless(name = "CustomerWS")
public class CustomerWebServiceImp implements CustomerWebService {

    @EJB private CustomerFinder finder;
    @EJB private CustomerRegistration registry;

    @Override
    public void register(String firstName,String lastName,String adress){
        registry.register(firstName,lastName,adress);
    }

    @Override
    public Customer findCustomer(String name){
        return finder.findByName(name);
    }


}
