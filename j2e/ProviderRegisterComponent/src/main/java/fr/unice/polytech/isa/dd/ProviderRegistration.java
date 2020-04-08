package fr.unice.polytech.isa.dd;

import javax.ejb.Local;



@Local
public interface ProviderRegistration {

     Boolean register(String providerName);
}
