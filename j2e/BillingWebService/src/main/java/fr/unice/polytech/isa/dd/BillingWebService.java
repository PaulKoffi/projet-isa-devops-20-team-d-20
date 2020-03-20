package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Bill;
import fr.unice.polytech.isa.dd.entities.ExternalPartnerException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Set;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/billingService")
public interface BillingWebService {


    @WebMethod
    @WebResult(name = "bill_generate")
    Set<Bill> generateBill();


    @WebMethod
    @WebResult(name = "billStatus")
    String checkstatut(@WebParam(name="id") int id) throws ExternalPartnerException;

}