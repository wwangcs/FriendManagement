package com.friendManagement.api.request;

public class SendMsgReq extends BasicReq{
    
    private String sender;
    private String test;
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }

}
