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

D.Webservice API
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
