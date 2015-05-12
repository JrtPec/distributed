/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloRemote;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface HelloBeanRemote {
    public String sayHello(String name);
    public ArrayList<String> getPersons();
    public void addPerson(String name);
}
