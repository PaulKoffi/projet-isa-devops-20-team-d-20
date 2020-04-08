package fr.unice.polytech.isa.dd;
import fr.unice.polytech.isa.dd.entities.Provider;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/providerService")
public interface ProviderWebService {

    @WebMethod
    Boolean register(@WebParam(name="provider_name") String name);

    @WebMethod
    @WebResult(name = "provider_find")
    Provider findProvider(@WebParam(name="provider_name") String name);
}
