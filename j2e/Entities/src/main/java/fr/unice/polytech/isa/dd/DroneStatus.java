package fr.unice.polytech.isa.dd;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

enum DRONE_STATES {
    AVAILABLE, AWAITING_DELIVER, IN_DELIVERING, AWAITING_LOADING, IN_LOADING, AWAITING_TO_BE_AVAILABLE, AWAITING_REPAIR, BEING_REPAIRED
}
@Entity
public class DroneStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private DRONE_STATES libelleStatusDrone;

    @NotNull
    private Date timeStartState;

    @NotNull
    private Date timeEndState;

    public DroneStatus(DRONE_STATES state, Date hourBeginning, Date hourEnd) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        timeEndState = hourEnd;
    }

    public int getId() {
        return this.id;
    }

    public DRONE_STATES getLibelleStatusDrone () {
        return libelleStatusDrone;
    }

    public Date getTimeStartState() {
        return timeStartState;
    }

    public Date getTimeEndState() {
        return timeEndState;
    }


}
