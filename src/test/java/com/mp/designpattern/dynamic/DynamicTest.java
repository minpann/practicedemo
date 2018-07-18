package com.mp.designpattern.dynamic;

import com.mp.designpattern.dynamic.impl.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by panmin on 16-12-22.
 */
public class DynamicTest {
    @Test
    public void dynamicTest() {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getName());
        System.out.println(userServiceProxy.getAddress());
    }
}
