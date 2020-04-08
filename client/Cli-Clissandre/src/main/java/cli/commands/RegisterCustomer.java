package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;

import java.util.List;

public class RegisterCustomer extends Command<DDPublicAPI> {

    private String customerN;
    private String customerP;
    private String customerA;

    @Override
    public String identifier() {
        return "registerCustomer";
    }

    @Override
    public void load(List<String> args) {
        int l = args.size();
        customerN = args.get(0);
        customerP = args.get(1);
        customerA = args.get(2);
        for (int i = 3; i < l; i++) {
            customerA = customerA + " " + args.get(i);
        }
    }

    @Override
    public void execute() {
        Boolean rep = shell.system.cws.register(customerN, customerP, customerA);
        if(rep){
            System.out.println("*** Enrégistré ***");
        }else {
            System.out.println("*** Echec de l'enrégistrement ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau client";
    }

}
