package fr.unice.polytech.isa.dd.webservice;

//import fr.unice.polytech.isa.dd.entities.Delivery;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.ExternalPartnerException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/billingService")
public interface BillingWebService {


    @WebMethod
    void generateBill();


    @WebMethod
    @WebResult(name = "billStatus")
    boolean checkstatut(@WebParam(name="id") int id) throws ExternalPartnerException;

}