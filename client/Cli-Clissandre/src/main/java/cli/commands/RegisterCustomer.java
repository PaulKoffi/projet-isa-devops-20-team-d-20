package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;

import java.util.List;

public class RegisterCustomer extends Command<DDPublicAPI> {

    private String customerN;
    private String customerP;
    private String customerA;

    @Override
    public String identifier() { return "registerCustomer"; }

    @Override
    public void load(List<String> args) {
        customerN = args.get(0);
        customerP = args.get(1);
        customerA = args.get(2);
    }

    @Override
    public void execute() {
        shell.system.cws.register(customerN,customerP,customerA);
        System.out.println("*** Enrégistré ***");
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau client";
    }

}
