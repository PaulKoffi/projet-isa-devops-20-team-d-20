package fr.unice.polytech.isa.dd;

public class BillingBean implements BillingGeneratedInterface,CheckTransferStatus {
    @Override
    public void generateBill() {

    }

    @Override
    public boolean checkstatut(String id) {
        return false;
    }
}
