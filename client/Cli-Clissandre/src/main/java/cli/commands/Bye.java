package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;

public class Bye extends Command<DDPublicAPI> {

	@Override
	public String identifier() { return "bye"; }

	@Override
	public void execute() { }

	@Override
	public String describe() {
		return "Exit Drone Delivery";
	}

	@Override
	public boolean shouldContinue() { return false; }

}
