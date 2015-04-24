/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class Hello {
    private String name;
    
    public Hello() {
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String user_name){
        this.name = user_name;
    }
}
