package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Provider;
import fr.unice.polytech.isa.dd.entities.Database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Stateless(name = "provider-stateless")
public class ProviderRegisterBean implements ProviderRegistration, ProviderFinder {

    @PersistenceContext private EntityManager entityManager;

    @Override
    public Boolean register(String provider_name) {
        //TODO
        Optional<Provider> Provider = findProviderByName(provider_name);
        if(Provider.isPresent()) return false;
        Provider new_Provider = new Provider(provider_name);
        entityManager.persist(new_Provider);
        return true;
        //listcutomer.add(Provider);
    }


    @Override
    public Provider findByName(String provider_name) {
        Optional<Provider> Provider = findProviderByName(provider_name);
        return Provider.orElse(null);
    }

    public Optional<Provider> findProviderByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Provider> criteria = builder.createQuery(Provider.class);
        Root<Provider> root =  criteria.from(Provider.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        TypedQuery<Provider> query = entityManager.createQuery(criteria);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException nre){
            return Optional.empty();
        }
    }
}
