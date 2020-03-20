package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.Bill;
import stubs.billing.ExternalPartnerException_Exception;
import stubs.delivery.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//public class GetNextDelivery {
public class CheckStatus extends Command<DDPublicAPI> {

    private int billId = -1;

    @Override
    public String identifier() {
        return "status";
    }

    @Override
    public void load(List<String> args) {
        billId = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute() throws ExternalPartnerException_Exception {
        String rep = shell.system.bws.checkstatut(billId);
        System.out.println("<-------------------/" + "\\------------------------->");
        if (rep.equals("PAID")) {
            System.out.println("Facture ¨Payée  !");
        } else if (rep.equals("UNPAID")) {
            System.out.println("Facture Impayée !");
        } else {
            System.out.println("Cette facture n'existe pas !");
        }
        System.out.println("<-------------------/" + "\\------------------------->");
    }

    @Override
    public String describe() {
        return "-----> Afficher les factures de la journée";
    }

}
