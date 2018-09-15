package com.friendManagement.api.Service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendManagement.api.common.JSONUtil;
import com.friendManagement.api.request.AddFriendReq;
import com.friendManagement.api.request.BlockFriendReq;
import com.friendManagement.api.request.CommonFriendReq;
import com.friendManagement.api.request.ListFriendReq;
import com.friendManagement.api.request.SendMsgReq;
import com.friendManagement.api.request.SubscribeReq;
import com.friendManagement.api.response.AddFriendResp;
import com.friendManagement.api.response.BlockFriendResp;
import com.friendManagement.api.response.CommonFriendResp;
import com.friendManagement.api.response.ListFriendResp;
import com.friendManagement.api.response.SendMsgResp;
import com.friendManagement.api.response.SubscribeResp;

public class FriendManagementService implements IFriendManagermentService {

    @Override
    @WebMethod(action = "addFriend")
    public String addFriend(String reqStr) throws Exception {
        AddFriendResp resp = new AddFriendResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            AddFriendReq req = mapper.readValue(reqStr, AddFriendReq.class);
            List<String> fre = req.getFriends();
            if (fre != null && fre.size() == 2) {
                // 1. check DB whether this two already friend. status is Accepted
                //  Relationship getRelationshipByUserAndStatus(String email1, String email2, String status);
                // 2. insert friend into DB
                //  void insertRelationship(int userOneId, int UserTwoId, String status);
                resp.setSuccess(true);
            }
        }
        return JSONUtil.ObjToStr(resp);
    }

    @Override
    public String listFriend(String reqStr) throws Exception {
        ListFriendResp resp = new ListFriendResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            ListFriendReq req = mapper.readValue(reqStr, ListFriendReq.class);
            String email = req.getEmail();
            //1. Base on Email to get the list From DB
            //List<User> getAllConnectionByStatus(String email, String status);
            //status = Accepted
            resp.setCount(1);
            resp.setSuccess(true);
            List<String> friends = new ArrayList<String>();
            friends.add("john@example.com");
            resp.setFriends(friends);
        }
        return JSONUtil.ObjToStr(resp);
    }

    @Override
    public String blockFriend(String reqStr) throws Exception {
        BlockFriendResp resp = new BlockFriendResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            BlockFriendReq req = mapper.readValue(reqStr, BlockFriendReq.class);
            req.getRequestor();
            req.getTarget();
            //update relationship table set status as blocked  based on req.getRequestor(); req.getTarget();
            //void updateRelationship(String userOne, String UserTwo, String status);
            resp.setSuccess(true);
        }
        return JSONUtil.ObjToStr(resp);
    }

    @Override
    public String commonFriend(String reqStr) throws Exception {
        CommonFriendResp resp = new CommonFriendResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            CommonFriendReq req = mapper.readValue(reqStr, CommonFriendReq.class);
            // 1. Check whether these two user in DB 
            //  User getUserByEmail(String email); email = fre.get(0), fre.get(1);
            // 2. List user one friends
            //List<User> getAllConnectionByStatus(String email, String status);
            //status = Accepted
            // 3. List user two friends
            //List<User> getAllConnectionByStatus(String email, String status);
            //status = Accepted
            // 4. Loop one user list, use other user list contains method then get the common friends.
            resp.setCount(1);
            resp.setSuccess(true);
            List<String> friends = new ArrayList<String>();
            friends.add("common@example.com");
            resp.setFriends(friends);
        }
        return JSONUtil.ObjToStr(resp);
    }

    @Override
    public String sendMsg(String reqStr) throws Exception {
        SendMsgResp resp = new SendMsgResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            SendMsgReq req = mapper.readValue(reqStr, SendMsgReq.class);
            req.getSender();
            req.getTest();
            // 1. List Accepted and Subscribe users with req.getSender().
            //List<User> getAllConnectionByStatus(String email, String[] status);
            resp.setSuccess(true);
            List<String> recipients = new ArrayList<String>();
            recipients.add("lisa@example.com");
            recipients.add("kate@example.com");
            resp.setRecipients(recipients);
        }
        return JSONUtil.ObjToStr(resp);
    }

    @Override
    public String subscribeMsg(String reqStr) throws Exception {
        SubscribeResp resp = new SubscribeResp();
        if (reqStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            SubscribeReq req = mapper.readValue(reqStr, SubscribeReq.class);
            req.getRequestor();
            req.getTarget();
            // 1. check DB whether this two already friend. status is Accepted
            //  Relationship getRelationshipByUserAndStatus(String email1, String email2, String status);
            // 2. update status to Subscribe
            // void updateRelationship(String userOne, String UserTwo, String status);
            resp.setSuccess(true);
        }
        return JSONUtil.ObjToStr(resp);
    }

}
