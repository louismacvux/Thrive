What technical debt has been cleaned up
========================================
In order to avoid technical debt in the future when adding multiple languages to the application, we removed all the hardcoded texts into the resource file. This makes code manageable as well since we do not have to open all the separate files to edit the texts. This was an inadvertent, reckless technical debt.

[link to commit](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/1aa3b456ca9852a8490422c3dad52347f438aa4d)

What technical debt did you leave?
==================================
There was one recommendation for the BloodInformation feature, which was to store the data about the blood marks in a Hashtable. We understood how this will greatly improve our code, especially reducing the open/close violation and hence further technical debt when adding on to this feature. However, it was deliberate and prudent to choose not to during this iteration because there were limitations to how much time we can put into this project. However, we did want to implement the hashtable before moving on with this specific feature. Therefore, we did not touch this feature more than what we have. Instead, implemented a new feature - Meal Plan. 

Discuss a Feature or User Story that was cut/re-prioritized
============================================
The Blood Health Optimizer was re-prioritized in our iteration 2 when we realized we would not be able to finish it in one iteration. Since this feature had two parts, one informative and one evaluation with user-entered data, we decided to split the feature in half and finish the first part and move the second part to the next iteration. However, we realized there were more refactoring and testings to do before moving on. Therefore, the second part of the feature has been reassigned to iteration FUTURE. 

[link to the re-prioritized feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/2)

[link to the first part of the feature that was completed](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/22)

Acceptance test/end-to-end
==========================
What we tested were four different scenarios based on the four features of our application. Each test simulated the process of a user using the corresponding feature. The process was from the login screen to the particular feature. For the feature such as wellness calculator, we tested all possible navigations that users can be doing from buttons and putting in values in the blanks and providing output accordingly. Unless the code is updated, our features do not have a potential flaky part since most of them are outputs of pdf files based on the values calculated. So the outcomes are deterministic. 

[link to the wellness calculator acceptance test](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/blob/master/app/src/androidTest/java/com/comp3350/WellnessCalculatorTest.java)

Acceptance test, untestable
===============
The only challenge was testing whether the pdf files were correctly loaded. Since the pdf files were considered as external things of the application, we were not able to test the current view of the UI that was showing correct texts. So, what we 
did was we made an invisible textView which received the name of the pdf file. Then, we tested if the textView was recieving the correct file name or not. This implies that we at least made sure the pdf UI file have the correct pdf file name.

Velocity/teamwork
=================
Our estimates got better through the course as shown below.
Our unit of measurement was the sum of the number of features, number of user stories, and implementation of the database. We learned from our completed work from iteration 1 and anticipated to complete 5 "works." We struggled with implementing the database in iteration 2, but other than that, we were very close to our estimation. Since we almost finished what we had planned for iteration 2, we thought 5 "works" are the right amount of work we can do for one iteraiton. However, the reason the committed work in iteration 3 was less than 5 was because the chart does not include other parts of the project such as refactoring and project presentation which we had to take into account when planning for handing all of them on the same day.
![alt text](iteration3Velocity.png)

