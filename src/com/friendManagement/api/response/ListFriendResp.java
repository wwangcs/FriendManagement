package com.friendManagement.api.response;

import java.util.List;

public class ListFriendResp extends BasicResp{
    
    private List<String> friends;
    
    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    private String count;

}
