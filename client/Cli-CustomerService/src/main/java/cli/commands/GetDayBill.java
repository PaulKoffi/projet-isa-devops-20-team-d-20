package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.Bill;
import stubs.delivery.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//public class GetNextDelivery {
public class GetDayBill extends Command<DDPublicAPI> {

    @Override
    public String identifier() {
        return "bill";
    }

    @Override
    public void execute() {
        List<Bill> result = shell.system.bws.generateBill();
        if (result.size() != 0) {
            for(Bill b: result) {
                System.out.println("<-------------------/"+"\\------------------------->");
                System.out.println("Id de La facture : " + b.getId());
                System.out.println("Le nom du transporteur est : " + b.getProvider().getName());
                System.out.println("Montant de la facture : " + b.getBillAmount());
                System.out.println("<-------------------/"+"\\------------------------->");
            }
        } else {
            System.out.println("Pas de livraison effectuées dans la journée");
        }
    }

    @Override
    public String describe() {
        return "-----> Afficher les factures de la journée";
    }

}
