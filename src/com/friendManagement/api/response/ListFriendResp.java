package com.friendManagement.api.response;

import java.util.List;

public class ListFriendResp extends BasicResp{
    
    private List<String> friends;
    private int count;
    
    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
