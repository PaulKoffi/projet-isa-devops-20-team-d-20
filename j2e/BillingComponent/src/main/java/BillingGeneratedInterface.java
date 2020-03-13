import fr.unice.polytech.isa.dd.Bill;
import fr.unice.polytech.isa.dd.Delivery;

import java.util.List;

public interface BillingGeneratedInterface {

    public List<Bill> generateBill(List<Delivery> ds);

}
