package com.friendManagement.api.dao;

import java.util.List;

public interface FriendmanagementDAO {
    
    /**
     * 
     * Users Table,This table contains 3 fields 
     * user_id
     * user_name
     * email
     * 
     * Relationship Table, table contains 3 fields
     * user_one_id
     * user_two_id
     * status
     * 
     * Status type
     * Pending
     * Accepted
     * Rejected
     * Blocked
     * Subscribe
     * 
     */
    //select * from user where email = ?
    User getUserByEmail(String email);
    
    //select r.* relationship r 
    //inner join user u1 on u1.user_id = r.user_one_id
    //inner join user u2 on u2.user_id = r.user_two_id
    //where u1.email = ? and u2.email = ? and r.status = ?
    Relationship getRelationshipByUserAndStatus(String email1, String email2, String status);
    
    //INSERT INTO Relationship (user_one_id, user_two_id, status)VALUES (? , ? , ?);
    void insertRelationship(int userOneId, int UserTwoId, String status);
    
    //select u.* from user u 
    //inner join relationship r on u.user_id = r.user_one_id
    //where u.email = ? and status in (?)
    List<User> getAllConnectionUsersByStatus(String email, String[] status);
    
    //update relationship set status = status 
    //where user_one_id = (select user_id from user where email = ? )
    //and user_two_id = (select user_id from user where email = ? )
    void updateRelationship(String userOne, String UserTwo, String status);

}
