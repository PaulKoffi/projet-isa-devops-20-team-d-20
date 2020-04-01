package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.entities.Delivery;
import fr.unice.polytech.isa.dd.entities.Package;
import fr.unice.polytech.isa.dd.entities.Provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Stateless(name="planning-stateless")
public class PlanningBean implements DeliveryRegistration{
    @PersistenceContext
    private EntityManager entityManager;

    private Customer customer;
    private Provider provider;

    @Override
    public void register_delivery(String name_client, String name_provider) {

        customer = findCustomerByName(name_client).get();
        provider = findProviderByName(name_provider).get();

        Delivery delivery = new Delivery();
        Package aPackage = (Package) provider.getPackages().toArray()[0];
        delivery.setPackageDelivered(aPackage);
        customer.add_a_customer_delivery(delivery);
        entityManager.persist(delivery);
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

    public Optional<Customer> findCustomerByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
        Root<Customer> root =  criteria.from(Customer.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        TypedQuery<Customer> query = entityManager.createQuery(criteria);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException nre){
            return Optional.empty();
        }
    }
}
