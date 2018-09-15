package com.friendManagement.api.entity.response;

import java.util.List;

public class SendMsgResp extends BasicResp{

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    private List<String> recipients;
}
