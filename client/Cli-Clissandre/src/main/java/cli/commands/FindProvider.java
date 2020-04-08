package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.provider.Provider;


import java.util.List;

public class FindProvider extends Command<DDPublicAPI> {

    private String name;

    @Override
    public String identifier() {
        return "findProvider";
    }

    @Override
    public void load(List<String> args) {
        int l = args.size();
        name = args.get(0);
        for (int i = 1; i < l; i++) {
            name = name + " " + args.get(i);
        }
    }

    @Override
    public void execute() {
        Provider p = shell.system.pws.findProvider(name);
        if (p != null) {
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("trouvé ::");
            System.out.println("<-------------------/" + "\\------------------------->");
        } else {
            System.out.println("Ce transporteur n'a pas encore été enregistré !");
        }
    }

    @Override
    public String describe() {
        return "-----> Rechercher un transporteur";
    }

}
