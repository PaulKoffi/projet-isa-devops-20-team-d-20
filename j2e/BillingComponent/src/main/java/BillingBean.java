import fr.unice.polytech.isa.dd.Bill;
import fr.unice.polytech.isa.dd.Delivery;
import fr.unice.polytech.isa.dd.Provider;

import java.util.List;

public class BillingBean implements BillingGeneratedInterface{

    public BillingBean() {
    }

    @Override
    public List<Bill> generateBill(List<Delivery> ds) {
        for (Delivery d: ds) {

        }
    return null;
    }

    public List <Provider> getAllProviders ( List <Delivery> deliveries){
    return null;
    }
}
