package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.delivery.Delivery;

import java.util.List;
//public class GetNextDelivery {
public class GetNextDelivery extends Command<DDPublicAPI> {

	@Override
	public String identifier() { return "delivery"; }

	@Override
	public void execute() {
		Delivery d = shell.system.dws.getNextDelivery();
		if(d != null){
			System.out.println("Le prix de cette livraison est " + d.getPrice());
			System.out.println("Le nom du client est " + d.getCustomer().getName());
		}else {
			System.out.println("  No delivery ");
		}
	}

	@Override
	public String describe() {
		return "List Next Delivery";
	}

}
