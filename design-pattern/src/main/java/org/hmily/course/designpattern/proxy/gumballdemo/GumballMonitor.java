package org.hmily.course.designpattern.proxy.gumballdemo;

public class GumballMonitor {

    GumballMachineRemote gumballMachineRemote;

    public GumballMonitor(GumballMachineRemote gumballMachineRemote){
        this.gumballMachineRemote=gumballMachineRemote;
    }

    public void report(){
        System.out.println("Gumball Machine: " + gumballMachineRemote.getLocation());
        System.out.println("Current inventory: " + gumballMachineRemote.getCount()+" gumballs");
        System.out.println("Current state: " + gumballMachineRemote.getState());
    }

}
