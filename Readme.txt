# FriendMangement

A. Framework used
JAX-RS
Jackson

B. Server is Tomcat

C. Code Structure
1.api.common: common tool
2.api.dao: DB design and SQL
3.api.entity: Request and Response Object
4.api.service: the main logic is in FriendManagementService class.
5.test: unit test case

How To Test:
Setup Web Service in Local
1. checkout apache-tomcat-7.0.90.zip
2. Unzip to any place
3. Make sure install JDK and put "JAVA_HOME" in Windows Environment.
4. Run \apache-tomcat-7.0.90\bin\startup.bat

Open Chrome install ARC app or any other RESTful webservice tools
The details of Webservice API like below.
1.addFriend
URL:
http://localhost:8080/FriendManagement/api/service/addFriend
Header:
Content-Type:application/json
Accept:application/json
Body:
{"friends":["andy@example.com","john@example.com"]}

2.listFriend
URL:
http://localhost:8080/FriendManagement/api/service/listFriend
Header:
Content-Type:application/json
Accept:application/json
Body:
{"email":"andy@example.com"}

3.commonFriend
URL:
http://localhost:8080/FriendManagement/api/service/commonFriend
Header:
Content-Type:application/json
Accept:application/json
Body:
{"friends":["andy@example.com","john@example.com"]}

4.subscribeMsg
URL:
http://localhost:8080/FriendManagement/api/service/subscribeMsg
Header:
Content-Type:application/json
Accept:application/json
Body:
{"requestor":"lisa@example.com","target":"john@example.com"}

5.blockFriend
URL:
http://localhost:8080/FriendManagement/api/service/blockFriend
Header:
Content-Type:application/json
Accept:application/json
Body:
{"requestor":"andy@example.com","target":"john@example.com"}

6.sendMsg
URL:
http://localhost:8080/FriendManagement/api/service/sendMsg
Header:
Content-Type:application/json
Accept:application/json
Body:
{"sender":"john@example.com","text":"Hello World! kate@example.com"}




Mock DAO, just design table and SQL
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
