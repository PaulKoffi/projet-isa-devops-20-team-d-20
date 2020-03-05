package fr.unice.polytech.isa.dd.interfaces;

import java.util.Date;

public interface PackageRegistration {

    public void register(String package_id, double package_weight, Date today_date);
}
