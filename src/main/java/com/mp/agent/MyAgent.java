package com.mp.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by panmin on 16-12-5.
 */
public class MyAgent{
    /**
     * 该方法是一个类作为agent类必备的
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs,Instrumentation inst){
        //加入ClassFileTransfomer
        inst.addTransformer(new PersonClassFileTransformer());
    }
}
