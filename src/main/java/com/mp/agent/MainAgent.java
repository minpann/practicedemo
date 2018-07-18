package com.mp.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by panmin on 16-12-6.
 */
public class MainAgent {
    public static void agentmain(String args, Instrumentation inst){
        Class[] classes = inst.getAllLoadedClasses();
        for(Class cls :classes){
            System.out.println(cls.getName());
        }
    }
}
