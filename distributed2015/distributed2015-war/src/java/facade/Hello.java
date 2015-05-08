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

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class Hello {
    private String name;
    private String customGreeting;
    
    @EJB
    private HelloBeanRemote helloRemote;

    public String getCustomGreeting() {
        return customGreeting;
    }

    public void setCustomGreeting(String customGreeting) {
        this.customGreeting = helloRemote.sayHello(customGreeting);
        //this.customGreeting = customGreeting;
    }
    
    public Hello() {
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String user_name){
        this.name = user_name;
    }
}
