package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Drone;

public class DoneManagementBean implements DroneRegister, DroneStatus,AvailableDrone {

    @Override
    public void register(int n_battery, int n_flightHours) {
    }

    @Override
    public DroneStatus status(int idDrone) {
        return null;
    }
}
