/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author JrtPec
 */
public class interceptor {
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("INTERCEPTOR");
        Object result = context.proceed();
        return result;
    }
}
