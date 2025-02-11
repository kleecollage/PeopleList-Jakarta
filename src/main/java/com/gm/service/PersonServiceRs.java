package com.gm.service;

import com.gm.data.IPersonDao;
import com.gm.domain.Person;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Stateless
@Path("/people")
public class PersonServiceRs {

    @Inject
    private IPersonDao personDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        List<Person> people = personDao.getAllPersons();
        System.out.println("People found: " + people);
        return people;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") // http://{host}/people/{id}
    public Person getPerson(@PathParam("id") int id) {
        Person person = personDao.getPersonById(new Person(id));
        System.out.println("Person found: " + person);
        return person;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        personDao.insertPerson(person);
        System.out.println("Person added: " + person);
        return person;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePerson(@PathParam("id") int id, Person personUpdated) {
        Person person = personDao.getPersonById(new Person(id));
        if (person != null) {
            personDao.updatePerson(person);
            System.out.println("Person updated: " + person);
            return Response.ok().entity(personUpdated).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int id) {
        personDao.deletePerson(new Person(id));
        System.out.println("Person with id: " + id + "deleted");
        return Response.ok().build();
    }
}










