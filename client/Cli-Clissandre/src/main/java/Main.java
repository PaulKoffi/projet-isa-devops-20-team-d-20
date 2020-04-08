import cli.commands.*;
import cli.framework.Shell;
import api.DDPublicAPI;

/**
 * An Interactive shell that interacts with a Cookie on Demand instance
 * Use -Dexec.args="IP_ADDRESS PORT_NUMBER" to change host/port parameters
 */
public class Main extends Shell<DDPublicAPI> {

    public Main(String host, String port) {

        this.system  = new DDPublicAPI(host, port);
        this.invite  = "DDelivery";

        // Registering the command available for the user
        register(
                // Getting out of here
                Bye.class,

                FindCustomer.class,

                FindProvider.class,

                RegisterProvider.class,

                RegisterCustomer.class
        );
    }

    public static void main(String[] args) {
        String host = ( args.length == 0 ? "localhost" : args[0] );
        String port = ( args.length < 2  ? "8080"      : args[1] );
        System.out.println("\n\nStarting Drone Delivery By Livrair");
        System.out.println("  - Remote server: " + host);
        System.out.println("  - Port number:   " + port);
        Main main = new Main(host, port);
        main.run();
        System.out.println("Exiting Drone Delivery By Livrair\n\n");
    }

}
