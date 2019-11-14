package org.hmily.course.designpattern.proxy.gumballdemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    private String location;

    private int numberGumballs;

    private int count;

    private State state;

    public GumballMachine(String location,int numberGumballs)throws RemoteException{
        this.location = location;
        this.numberGumballs=numberGumballs;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberGumballs() {
        return numberGumballs;
    }

    public void setNumberGumballs(int numberGumballs) {
        this.numberGumballs = numberGumballs;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public State getState() {
        return state;
    }
}
