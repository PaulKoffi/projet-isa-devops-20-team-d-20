package fr.unice.polytech.isa.dd.interfaces;

public interface DroneStatus {

    // Changer le type de retour en Drone
    public void getAllLoadingDrone();

    // Changer le type de retour en Drone
    public void getAllFixingDrone();

    //Mettre les paramètres une fois les classes créées
    public void setStatutsDrone();

    //Mettre les paramètres une fois les classes créées et changer le type de retour en Status_Drone
    public void getAllHistoryDrone(String drone);

    // Changer le type de retour en Status_Drone
    public void getAllHistory();
}
