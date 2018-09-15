package com.friendManagement.test;

import java.util.ArrayList;
import java.util.List;

import com.friendManagement.api.Service.FriendManagementService;
import com.friendManagement.api.common.JSONUtil;
import com.friendManagement.api.entity.request.AddFriendReq;
import com.friendManagement.api.entity.request.BlockFriendReq;
import com.friendManagement.api.entity.request.CommonFriendReq;
import com.friendManagement.api.entity.request.ListFriendReq;
import com.friendManagement.api.entity.request.SendMsgReq;
import com.friendManagement.api.entity.request.SubscribeReq;

public class TestAPI {

  public static void main(String[] args){
        
      TestAPI test = new TestAPI();
      test.testAddFriend();
      test.testListFriend();
      test.testCommonFriend();
      test.testSubscribeMsg();
      test.testBlockFriend();
      test.testSendMsg();
    }
  
    public void testAddFriend() {
        FriendManagementService service = new FriendManagementService();
        AddFriendReq req = new AddFriendReq();
        List<String> friends = new ArrayList<String>();
        friends.add("andy@example.com");
        friends.add("john@example.com");
        req.setFriends(friends);
        try {
            System.out.println(service.addFriend(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testListFriend() {
        FriendManagementService service = new FriendManagementService();
        ListFriendReq req = new ListFriendReq();
        req.setEmail("andy@example.com");
        try {
            System.out.println(service.listFriend(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testCommonFriend() {
        FriendManagementService service = new FriendManagementService();
        CommonFriendReq req = new CommonFriendReq();
        List<String> friends = new ArrayList<String>();
        friends.add("andy@example.com");
        friends.add("john@example.com");
        req.setFriends(friends);
        try {
            System.out.println(service.commonFriend(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testSubscribeMsg() {
        FriendManagementService service = new FriendManagementService();
        SubscribeReq req = new SubscribeReq();
        req.setRequestor("lisa@example.com");
        req.setTarget("john@example.com");
        try {
            System.out.println(service.subscribeMsg(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testBlockFriend() {
        FriendManagementService service = new FriendManagementService();
        BlockFriendReq req = new BlockFriendReq();
        req.setRequestor("andy@example.com");
        req.setTarget("john@example.com");
        try {
            System.out.println(service.blockFriend(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testSendMsg() {
        FriendManagementService service = new FriendManagementService();
        SendMsgReq req = new SendMsgReq();
        req.setSender("john@example.com");
        req.setTest("Hello World! kate@example.com");
        try {
            System.out.println(service.sendMsg(JSONUtil.ObjToStr(req)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
