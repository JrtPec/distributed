/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import helloRemote.HelloBeanRemote;
import javax.ejb.Stateless;

/**
 *
 * @author Jan
 */
@Stateless
    public class HelloBean implements HelloBeanRemote {

    @Override
    public String sayHello(String name) {
        return "Bean speaking. Hello "+name;
    }
}
