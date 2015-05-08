/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface Hello {
    public void sayHello(String name);
}