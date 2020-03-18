package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Bill;
import fr.unice.polytech.isa.dd.entities.ExternalPartnerException;

import java.util.List;

public interface CheckTransferStatus {

    public boolean checkstatut(int id);

    public List<Bill> getAllPaidBills() throws ExternalPartnerException;
}
