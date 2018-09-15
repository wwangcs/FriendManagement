package com.friendManagement.api.service;

import javax.ws.rs.core.Response;


public interface IFriendManagermentWebService {

    Response addFriend(String req) throws Exception;

    Response listFriend(String req) throws Exception;

    Response blockFriend(String req) throws Exception;

    Response commonFriend(String req) throws Exception;

    Response sendMsg(String req) throws Exception;

    Response subscribeMsg(String req) throws Exception;

}
