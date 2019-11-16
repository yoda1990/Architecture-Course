package org.hmily.course.designpattern.proxy.gumballdemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {

        String[] location = {"123","456","789"};

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i=0;i<location.length;i++){
            try {
                GumballMachineRemote gumballMachineRemote = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(gumballMachineRemote);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
