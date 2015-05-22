/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import entities.Person;
import helloRemote.HelloBeanRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
    public class HelloBean implements HelloBeanRemote {
    
    @PersistenceContext
    private EntityManager em;
  
    @Override
    public String sayHello(String name) {
        return "Bean speaking. Hello "+name;
    }

    @Override
    public List<Person> fetchPersons() {      
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    @Override
    public void addPerson(String first_name, String last_name) {
        Person newPerson = new Person();
        newPerson.setFirst_name(first_name);
        newPerson.setLast_name(last_name);
        em.persist(newPerson);
    }
}
