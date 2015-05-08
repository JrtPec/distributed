/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import helloRemote.HelloBeanRemote;
import java.util.ArrayList;

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class Hello {
    private String name;
    private String customGreeting;
    private ArrayList<String> users = new ArrayList<String>();
    
    @EJB
    private HelloBeanRemote helloRemote;
    
    public Hello() {
        users.add("Jan");
        users.add("Peter");
        users.add("Tom");
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String user_name){
        this.name = user_name;
    }
    
    public String getCustomGreeting() {
        return customGreeting;
    }

    public void setCustomGreeting(String customGreeting) {
        this.customGreeting = helloRemote.sayHello(customGreeting);
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
