package org.hmily.im.beans;

import org.hmily.im.base.BaseMsg;
import org.hmily.im.base.MsgType;

public class ReplyMsg extends BaseMsg {

    public ReplyMsg() {
        super();
        setMsgType(MsgType.REPLY);
    }
    private ReplyBody body;

    public ReplyBody getBody() {
        return body;
    }

    public void setBody(ReplyBody body) {
        this.body = body;
    }
}
