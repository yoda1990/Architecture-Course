package org.hmily.im.beans;

import org.hmily.im.base.BaseMsg;
import org.hmily.im.base.MsgType;

public class LoginMsg extends BaseMsg {

    String username;

    String password;

    public LoginMsg() {
        super();
        setMsgType(MsgType.LOGIN);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
