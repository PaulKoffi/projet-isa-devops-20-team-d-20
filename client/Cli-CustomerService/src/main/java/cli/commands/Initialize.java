package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.delivery.Delivery;

import java.util.List;
//public class GetNextDelivery {
public class Initialize extends Command<DDPublicAPI> {

    @Override
    public String identifier() { return "init"; }

    @Override
    public void execute() {
        shell.system.dws.initializeDelivery();
    }

    @Override
    public String describe() {
        return "Init Delivery List in Database";
    }

}
