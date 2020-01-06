package org.hmily.im.beans;

import org.hmily.im.base.BaseMsg;
import org.hmily.im.base.MsgType;

public class PingMsg extends BaseMsg {

    public PingMsg() {
        super();
        setMsgType(MsgType.PING);
    }
}
