package fr.unice.polytech.isa.dd.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

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
        this.libelleStatusDrone=  state;
        this.timeStartState = hourBeginning;
        this.timeEndState = hourEnd;
    }

    public int getId() {
        return this.id;
    }

    public DRONE_STATES getLibelleStatusDrone () {
        return this.libelleStatusDrone;
    }

    public Date getTimeStartState() {
        return this.timeStartState;
    }

    public Date getTimeEndState() {
        return this.timeEndState;
    }


}
