package fr.unice.polytech.isa.dd.webservice;
import fr.unice.polytech.isa.dd.*;
import fr.unice.polytech.isa.dd.entities.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.HashSet;
import java.util.Set;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/billingService")
@Stateless(name = "BillingWS")
public class BillingWebServiceImp implements BillingWebService{


    @EJB private BillingGeneratedInterface bg;
    @EJB private CheckTransferStatus cs;

    @Override
    public Set<Bill> generateBill(){
        Database.getInstance().initializeDatabase();
        bg.generateBill();
        Set<Bill> result = new HashSet<>();
        for(Bill b: Database.getInstance().getBillList()) {
                result.add(b);
        }
        return result;
    }

    @Override
    public boolean checkstatut(int id) throws ExternalPartnerException {
        return cs.checkstatut(id);
    }
}
