package com.gm.data;

import com.gm.domain.Person;

import java.util.List;

public interface IPersonDao {
    public List<Person> getAllPersons();

    public Person getPersonById(Person person);

    public void insertPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);
}
