package fr.unice.polytech.isa.dd;

public class DroneManagementBean implements AvailableDrone,DroneRegister,DroneStatus {
    @Override
    public void register(int n_battery, int n_flightHours) {

    }

    @Override
    public DroneStatus status(int idDrone) {
        return null;
    }
}
