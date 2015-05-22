/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloRemote;

import entities.Person;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface HelloBeanRemote {
    public String sayHello(String name);
    public List<Person> fetchPersons();
    public void addPerson(String first_name, String last_name);
}
