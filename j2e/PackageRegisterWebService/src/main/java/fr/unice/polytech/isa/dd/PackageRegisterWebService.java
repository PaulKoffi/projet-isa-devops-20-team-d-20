package fr.unice.polytech.isa.dd;

//import fr.unice.polytech.isa.dd

import fr.unice.polytech.isa.dd.entities.Provider;
import fr.unice.polytech.isa.dd.entities.Package;

import org.joda.time.DateTime;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/package")
public interface PackageRegisterWebService {

    @WebMethod
    void register(@WebParam(name="id") int nb,
                  @WebParam(name="w") Double w,
                  @WebParam(name="dateTime") DateTime dt,
                  @WebParam(name="provider") Provider pro);



    @WebMethod
    @WebResult(name = "package")
    Package findPackage(@WebParam(name="id") int nb);
}
