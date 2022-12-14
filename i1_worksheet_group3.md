Iteration 1 Worksheet
=====================

Adding a feature
-----------------

It was during one of our first group meetings that we decided our first feature. For our app Thrive, which pursues overall well-being and health, one of the main feature was "workout suggestion." We concluded that it would be a good way to start off our project as it would be straight forward to implement and it is one of our high priority features. This workout suggestion feature would suggest workout plans to the users based on their information. 

* link to feature: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/1
* link to user story: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/17
* merge requests (if used): https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/merge_requests/1
* associated tests: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/tree/development/app/src/test/java/com/example/comp3350
* merge commit: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/merge_requests/1

Exceptional code
----------------


(Note: You must be signed into Gitlab for the link to work)<br/>
https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/16952a112d9ae0caf69bc1cdc45de82b56d34cdb#328091f14f1bcab81af6de76dcf15b07daf71bef<br/><br/>
Directory location:<br/>
app/src/main/java/com/example/comp3350/RegisterActivity.java<br/><br/>
Lines 66, 76 and 86<br/>
These exceptional codes test whether numeric values for age, weight, and height are successfully converted to and integer after being entered in by our client. 
Since when the client originally enters this information it is a string variable so the parseInt() should be successful each time they are called as there 
should not be an issue with that type of conversion using parseInt(). 
However, ensuring that the information was correctly retrieved from our clients before being stored we needed to ensure it was in the correct format.

Branching
----------

https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/blob/development/README.md

![alt text](branching-strategy.jpg)

SOLID
-----

For our group we need to find a SOLID violation in group 5. Here is a link to the created issue. 
https://code.cs.umanitoba.ca/3350-winter-2021-a02/group5/-/issues/64

Agile Planning
--------------

We do have 2 features and 2 user stories that we pushed to iteration 2 which is for the blood health optimizer and wellness calculator feature. 
* link to feature: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/2 , https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/4
* link to user story 1: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/11
* link to user story 2: https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/18

We realized that for this iteration we would have a little extra work figuring out coding in Android Studio along with the starting point of the interface, so we decided to focus more on the workout suggestion with the login and registration page at the start of the application. 
