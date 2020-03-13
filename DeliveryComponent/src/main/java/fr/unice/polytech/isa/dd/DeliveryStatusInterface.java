package fr.unice.polytech.isa.dd;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DeliveryStatusInterface {

    List<Drone> getAllLoadingDrone();

    List<Drone> getAllFixingDrone();

    void StatusDrone(String drone_id, String statusDrone, String hour);

    Optional<DroneStatus> getAllHistoryDrone(String drone_id);

    Optional<DroneStatus> getAllHistoryDrone();
}
