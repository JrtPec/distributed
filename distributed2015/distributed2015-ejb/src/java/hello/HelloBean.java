/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import entities.Someone;
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
    public ArrayList<String> getUsers() {
        Someone u1 = new Someone();
        u1.setName("Jan");
        em.persist(u1);
        System.out.println(u1.getId() + u1.getName());
        em.flush();
        
        ArrayList<String> users = new ArrayList<>();
        users.add(u1.getName());
        users.add("Peter");
        users.add("Tom");
        return users;
    }
}
