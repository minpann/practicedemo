package com.mp.agent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Created by panmin on 16-12-6.
 */
public class TestMainAgent {
    public static void main(String[]args) throws InterruptedException, IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        VirtualMachine vm = VirtualMachine.attach(args[0]); //正在运行的java 程序 ps id
        vm.loadAgent("/data/ideaProject/JavaWebTest/target/classes/agentmain.jar");
        //刚刚编译好的agent jar 位置
    }
}
