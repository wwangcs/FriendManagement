package com.friendManagement.api.request;

import java.util.List;

public class AddFriendReq extends BasicReq{
    
    private List<String> friends;

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

}
