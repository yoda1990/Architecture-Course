package org.hmily.im.base;

import java.io.Serializable;

public abstract class BaseMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    private MsgType msgType;
    private String clientID;

    public BaseMsg() {
        this.clientID = Constants.getClientID();
    }

    public MsgType getMsgType() {
        return msgType;
    }
    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }
    public String getClientID() {
        return clientID;
    }
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
