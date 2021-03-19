# **GROUP 3 - THRIVE ITERATION 2 WORKSHEET**

## Paying off technical debt
### _Reflecting our architecture_

Our group did not properly group our files in a way that reflected our design architecture. Though Android Studio will seperate our java class files from our .xml layout files, our java class files were all in one folder. This led to some disorganization when group members were working on their respective tasks.

Having now isolated each class into either our UI/Presentation, Logic/Business or Data/Persistence layer. We did move our 'User' object into its own seperate folder for ease of access as this object is often referred to in all aspects of our architecture. 

This technical debt can be classified as prudent and inadvertent. The restructuring of our java files into their resepctive roles in our architecture was relatively straightforward, and had our group recognized its benefits, it would have been implimented from the begining. One could describe this debt as a result of our "un-willful ignorance".
 
[link to commit:] (https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/107f401ec422e4ff967ddb9837921e95711eae02)

### _Rounding out DB functionality_

We had begun to impliment a database using an extended class of 'SQLiteOpenHelper'. However, in order to make the iteration one deadline, our group push the db implimentation without full basic functionality. For instance, the application did not update the database tables if our USER object's variables were updated. We've now gone back to our database code and updated it to provide full basic funtionality.

This technical debt is classified as deliberate and reckless. Our group was fully aware an incomplete database helper class was being pushed for the release of iteration1. The group was also aware these issues would need to be addressed as soon as possible.

[DatabaseHelp Class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/06f0bc3571b826a3932a4a244287ddbffdcdd9dd#e2eafdb9b47a36cbc785491a61db5e44c65ddcf4_153_199)
[User Object class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/06f0bc3571b826a3932a4a244287ddbffdcdd9dd#e25262f80a9bf55e06658be3651379982d23063e_39_77)

## SOLID VIOLATIONS - Single-Responsibility Principle
###  _must choose group 3 from (2%3 + 1) A03_

This group's project has a heirarchy of objects, whose parent object class is named "Utility". In this commit, their are two children objects showing: ClockUtility and NoteUtility. Notes are objects that are invoked by these utility children classes.

Consider the following: The ClockUtility child class has a function to get the current time 'getTime'. The NoteUtility class does NOT have this feature, however the Note object has the same code. The 'getTime' function in the 'Note' object class is used to show users the last time a note was updated.

However, if you look at the Utility parent class, it has defined functions for getting and setting a utility's usage frequency. The Note class should not be tasked with tracking or displaying timestamps, given the implementation of the Utility class hierarchy.

[link to issue](https://code.cs.umanitoba.ca/3350-winter-2021-a03/youtilities-comp3350-a03-group3/-/issues/42)
[link to commit: ](https://code.cs.umanitoba.ca/3350-winter-2021-a03/youtilities-comp3350-a03-group3/-/tree/logic-development/app/src/main/java/com/comp3350a03/group03/youtitlties/objects)

## RETROSPECTIVE
### How have things changed?

Our retrospective forced our group to consider what mistakes were made during iteration 1. Considering we had a relatviely low mark, it could not be ignored that there was room to improve as a group.

At the begining of this iteration, we met as a group via ZOOM. We had previously met in voice-only meetings but decided it was better to see each other during meetings. Our first meeting was spent acknowledging how we underestimated our timelines and left some of the more important aspects of the iteration, such as testing, to the end. In hindsight, we should have tested more proactively. We finished off the meeting with each of us to investigate how we could contribute to the next iteration's success. We agreed to meet a few days later to touch base on how we would proceed for the next few weeks.

After our second meeting, we updated our meeting notes and agreed upon tasks using notion.io here: [https://www.notion.so/invite/82601b1c3251528e6e98bbab6ff6b58937dca662].

## DESIGN PATTERNS
### Adapter

A DatabaseHelper class is implemented such that our other classes and activity files can interact with the application's permanent storage without directly issuing sql commands. Each class or activity can instead create a databaseHelper object with can then be used as needed. The databaseHelper object uses given parameters to then construct and apply the appropriate sql commands to the database.

[link to commit](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/06f0bc3571b826a3932a4a244287ddbffdcdd9dd)
[link to issue](https://code.cs.umanitoba.ca/3350-winter-2021-a03/youtilities-comp3350-a03-group3/-/issues/42)
###Chain of Responsibility

Both of our application's LoginActivity and RegisterActivity files follow this design practice, albeit minimally; their respective chains have only one link each. that being said, those chain-links are responsible for validating client input. for instance, the LoginManager file checks to ensure that user names exist in the local database or prompt users to create a new user account. the RegisterManager file ensures that all fields are entered and have the proper type of information showing. For instance, a user email must follow the "asd@xyz.com" format.

[link to commit LoginManager:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/4d8d16dfb575d091991d9013475b563a7729984e#762c7464f0fd966484e612d86660c2dfbf18f446_0_47)
[link to commit RegisterManager:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/107f401ec422e4ff967ddb9837921e95711eae02#f8b78a8c92a5fafeee2361f5f921606f26385d89_0_73)

## ITERATION 1 FEEDBACK FIXES

### Proper validation of user input in the login/registration activities.

Login/Register Manager classes are created to handle the logic-related requirements for checking and validating user input. These activities now only ensure that fields are not empty before invoking their respective manager classes.

[link to commit LoginManager:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/4d8d16dfb575d091991d9013475b563a7729984e#762c7464f0fd966484e612d86660c2dfbf18f446_0_47)
[link to commit RegisterManager:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/107f401ec422e4ff967ddb9837921e95711eae02#f8b78a8c92a5fafeee2361f5f921606f26385d89_0_73)

### Code Smell: ViewPDF.java

The nested 'if' statements used to check which PDF files to load have been greatly simplified, as was brought to our attention in our iteration 1 feedback. PDF files names have also been approriately renamed to allow for better distinction between their use.

[link to commit:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/0ba3645bdeb69c9acbe24719b27452da3bcd314e)

## Refractor our package to remove "com.example" and seperate files into packages based on tiers

Our project package has been simplified as stated in our feedback. Our files were previously all lumped together in one folder. Now they are properly seperated into subfolder to reflect their tier within our application's architecture. 

[link to commit:](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/commit/107f401ec422e4ff967ddb9837921e95711eae02)