# Lab 07 - Grocery List
This lab will focus working with [ArrayLists](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) and the [For-Each Loop](https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html). There will be some additional information near the bottom of this document if you need to gain a better understanding of today's topics.

For ease of access, here is the [javadoc](https://www.cs.colostate.edu/~cs163/javadoc/lab07/package-summary.html).

## Pre-Step: Testing
Whenever you implement one of these broken methods, a testing file ,`GroceryTests.java`, has been provided for you to test each method you have worked on before moving on to the next step. All that is needed is to uncomment the `System.out.println()` lines when you would like to test said method.

It is also highly encouraged to create new tests as well, so feel free to create new methods and call them within `GroceryTests.java`!

## Step 1: Compilation
At the moment you should be able to compile and run the program that begins in `GroceryMain.java`. If you have any troubles with this you may want to redownload the files or ask a TA. The [R]emove, [P]rint, and [G]et Aisle Groceries are currently nonfunctioning, but we will get this App fully functioning during this lab!

## Step 2: Self-Explanation
Within the `GroceryList` class you will find the `removeGrocery()` method along with the later `getTotals()` which may help with your explanation that is needed for `removeGrocery()`. Given the current code within the `removeGrocery()` method you can get some indication as to what it needs, but the [javadoc](https://www.cs.colostate.edu/~cs163/javadoc/lab07/package-summary.html) may also come in handy for this step and the next. The For-Each loop is functional, but you will have to fill in the contents of the conditional statement, which is currently *false*.

For this step, write down your self-explanation in the multi-line comment as to what the method is currently doing, and what is needed to make it fully functional. Once you have completed this self-explanation, right or wrong, try to apply your proposed change and use the `GroceryTests` `main` method to see if the output is correct.

## Step 3: Pseudocoding and Implementing
For this next step, you will be tasked with two more methods in the `GroveryList` class. This time you should pseudocode as you did in last weeks lab, the [javadoc](https://www.cs.colostate.edu/~cs163/javadoc/lab07/package-summary.html)  will come in handy once again. Remember that pseudocode is combining english and code to create an easily readable map to assist you in actually implementing your method or program. Don't delete the pseudocode as you implement, so the TA's can verify you pseudocoded.

Once you have completed the pseudocoding portion for each method, or just one, move onto implementing that method. Reminder that there are tests within the `GroceryTests.java` that you can use to ensure your implementation is correct.

## Step 4: Try the GroceryTrip Application
Once each of your test cases have told you they are correct, it would be wise to run the entire application before turning it in. So swap over to the `GroceryMain` class and check it out. Don't forget the format of input that is needed when adding new groceries!

## Step 5: Finishing up
After you have tested out the application and feel confident, turn in your program files to zyBooks.
After turning in your files, show your self-explanation and pseudocode to your TA.

# Additional Information
## ArrayLists
`ArrayList`s are an incredibly useful data container, meaning you can hold multiple objects of the same type within one! Lets say we wanted to create an `ArrayList` that held the type `String`. We would declare our `ArrayList` like so:
```java
ArrayList<String> strArrList = new ArrayList<String>();
```
Now we have this container, how do we actually add Strings to it to hold? We can use a method that is associated with the `ArrayList` class (somewhat similar to whenever we use `equals()` for a String), this method is the `add()` method:
```java
String toAdd = "Add this to the ArrayList";
strArrList.add(toAdd);
```
It's as simple as that, but now if we wanted to look at what is in our ArrayList we must the `get()` method:
```java
String hasBeenAdded = strArrList.get(0);
```
Now the value of hasBeenAdded is "Add this to the ArrayList". The **0** being used in that previous snippet is used to "get" whatever index is provided, so "getting" 0 gets the 0th index of the ArrayList.

There are many helpful methods associated with the ArrayList data contained which can be checked out [here](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). Focusing on the For-Each loop will be very helpful.

## For-Each Loop
The For-Each loop is a slightly different version of the typical *while* and *for* loop we are so used to using. It begins like a for loop, but there are two portions in the parentheses you must customize. The first portion being the Element that will be looped or iterated through. The second is the container that will be iterated through.
If we were to iterate through our previously created ArrayList it would look like this:
```java
for(String str: strArrList) {
    System.out.println(str);
}
```
So for each time one loop is completed, the `str` variable changes to the next data that is contained within the loop. If we had two Strings in the strArrList, "One" & "Two". On the first iteration, `str` would be equal to "One" and be printed, then on the second iteration it would be equal to "Two" and subsequently printed.

The For-Each loop then realizes there are no more Strings in our container and the loop is exited.
