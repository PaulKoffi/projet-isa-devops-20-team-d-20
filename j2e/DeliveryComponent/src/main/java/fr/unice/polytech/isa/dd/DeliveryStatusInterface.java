package fr.unice.polytech.isa.dd;

<<<<<<< HEAD:DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryStatusInterface.java
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

=======
import javax.ejb.Local;

@Local
>>>>>>> 3f87aa7e3330f867641231157a7eb2116bf6db12:j2e/DeliveryComponent/src/main/java/fr/unice/polytech/isa/dd/DeliveryStatusInterface.java
public interface DeliveryStatusInterface {

    List<Drone> getAllLoadingDrone();

    List<Drone> getAllFixingDrone();

    void StatusDrone(String drone_id, String statusDrone, String hour);

    Optional<DroneStatus> getAllHistoryDrone(String drone_id);

    Optional<DroneStatus> getAllHistoryDrone();
}
