package fr.unice.polytech.isa.dd.webservice;

import fr.unice.polytech.isa.dd.*;

import fr.unice.polytech.isa.dd.entities.BankAPI;
import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.ExternalPartnerException;

import javax.ejb.EJB;

public class BillingWebServiceImp implements BillingWebService{

    @EJB
    private BillingBean bg;

    @Override
    public void generateBill(){
        bg.generateBill();
    }

    @Override
    public boolean checkstatut(int id) throws ExternalPartnerException {
        return bg.checkstatut(id);
    }
}
