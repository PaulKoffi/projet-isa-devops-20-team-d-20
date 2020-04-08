package fr.unice.polytech.isa.dd;

//import fr.unice.polytech.isa.dd

import fr.unice.polytech.isa.dd.entities.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/customerService")
public interface CustomerWebService {

    @WebMethod
    Boolean register(@WebParam(name="customer_first_name") String firstName,
                  @WebParam(name="customer_last_name") String lastName,
                  @WebParam(name="customer_adress") String adress);



    @WebMethod
    @WebResult(name = "customer_find")
    Customer findCustomer(@WebParam(name="customer_name") String name);
}
