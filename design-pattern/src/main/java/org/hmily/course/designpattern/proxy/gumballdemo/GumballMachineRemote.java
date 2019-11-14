package org.hmily.course.designpattern.proxy.gumballdemo;

import java.rmi.Remote;

public interface GumballMachineRemote extends Remote {

    int getCount();

    String getLocation();

    State  getState();

}
