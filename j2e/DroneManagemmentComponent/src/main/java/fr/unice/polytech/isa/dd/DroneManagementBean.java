package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Drone;
import fr.unice.polytech.isa.dd.entities.Package;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless(name="drone-stateless")
public class DroneManagementBean implements AvailableDrone,DroneRegister,DroneStatus {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DroneStatus status(int idDrone) {
        return null;
    }

    @Override
    public void register( int n_battery, int n_flightHours) {
        Drone new_drone= new Drone(n_battery,n_flightHours);
        entityManager.persist(new_drone);
    }
}
