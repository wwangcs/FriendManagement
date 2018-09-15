package com.friendManagement.api.Service;


public interface IFriendManagermentService {

    String addFriend(String req) throws Exception;

    String listFriend(String req) throws Exception;

    String blockFriend(String req) throws Exception;

    String commonFriend(String req) throws Exception;

    String sendMsg(String req) throws Exception;

    String subscribeMsg(String req) throws Exception;

}
