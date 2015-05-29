/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Person;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import helloRemote.HelloBeanRemote;
import java.util.List;

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class Hello {
    private String first_name;
    private String last_name;
    private int userId;
    private int songId;
    private String customGreeting;
    
    @EJB
    private HelloBeanRemote helloRemote;
    
    public Hello() {
    }
    
    public String getFirst_name(){
        return first_name;
    }
    
    public void setFirst_name(String user_name){
        this.first_name = user_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }
    
    public String getCustomGreeting() {
        return customGreeting;
    }

    public void setCustomGreeting(String customGreeting) {
        this.customGreeting = helloRemote.sayHello(customGreeting);
    }
    
    public void addPerson(){
        helloRemote.addPerson(this.getFirst_name(), this.getLast_name());
    }
    
    public void buySong(){
        helloRemote.buySong(this.getUserId(), this.getSongId());
    }

    public List<Person> getPersons() {
        return helloRemote.fetchPersons();
    }
}