package org.hmily.im.beans;

import org.hmily.im.base.AskParams;
import org.hmily.im.base.BaseMsg;

public class AskMsg extends BaseMsg {

    AskParams askParams;

    public AskMsg(AskParams askParams) {
        this.askParams = askParams;
    }

    public AskParams getParams() {
        return askParams;
    }
}
