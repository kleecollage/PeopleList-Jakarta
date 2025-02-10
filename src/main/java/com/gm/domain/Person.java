package com.gm.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "person", schema = "java_test")
@NamedQueries({
        @NamedQuery(name = "Person.findAllPersons", query = "SELECT p FROM Person p ORDER BY p.idPerson")
})
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int idPerson;

    private String name;

    public Person() { }

    public Person(int idPerson) {
        this.idPerson = idPerson;
    }

    public Person(int idPerson, String name) {
        this.idPerson = idPerson;
        this.name = name;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                '}';
    }
}
