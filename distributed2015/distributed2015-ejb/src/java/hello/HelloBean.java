/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import entities.Person;
import helloRemote.HelloBeanRemote;
import java.util.ArrayList;
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
    public ArrayList<String> getPersons() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Tom");
        return names;
    }

    @Override
    public void addPerson(String name) {
        Person newPerson = new Person();
        newPerson.setName(name);
        em.persist(newPerson);
    }
}
