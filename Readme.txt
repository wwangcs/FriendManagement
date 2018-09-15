A. Framework used
JAX-RS
Jackson

B. Server is Tomcat

C. Code Structure
1.api.common: common tool
2.api.dao: DB design and SQL
3.api.entity: Request and Response Object
4.api.service: the main logic is in FriendManagementService class.
There are 6 APIs
addFriend();
listFriend();
commonFriend();
subscribeMsg();
blockFriend();
sendMsg();

5.test: unit test case
testAddFriend();
testListFriend();
testCommonFriend();
testSubscribeMsg();
testBlockFriend();
testSendMsg();

