package com.gm.data;

import com.gm.domain.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PersonDaoImpl implements IPersonDao {

    @PersistenceContext(unitName = "PeoplePU")
    EntityManager em;

    @Override
    public List<Person> getAllPersons() {
        return em.createNamedQuery("Person.findAllPersons", Person.class).getResultList();
    }

    @Override
    public Person getPersonById(Person person) {
        return em.find(Person.class, person.getIdPerson());
    }

    @Override
    public void insertPerson(Person person) {
        em.persist(person);
        em.flush();
    }

    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.remove(em.merge(person));
    }
}
