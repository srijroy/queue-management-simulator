# Queue Management Simulator

## Overview

This project is a simple Java console application that simulates a queue system like the ones used in hospitals or banks. In real life, not everyone is served in the order they arrive — emergency cases or elderly people are often given priority.

This program tries to replicate that behavior at a small level using Java.

---

## Problem Statement

In many real-world situations, a normal queue (first-come-first-served) is not efficient. For example, in hospitals, emergency patients should be treated before others.

The aim of this project is to create a system where people are served based on priority instead of just arrival time.

---

## Features

* Add a person to the queue
* Assign type: Normal, Elderly, or Emergency
* Automatically treat age above 60 as Elderly
* Serve people based on priority
* View the current queue
* Display statistics (waiting, served, etc.)
* Data is saved to a file and loaded when the program restarts

---

## Priority Rules

* Emergency → Highest priority
* Elderly → Medium priority
* Normal → Lowest priority

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework (PriorityQueue, Comparator)
* File Handling

---

## How to Run

1. Open the project in VS Code or any Java IDE
2. Compile all files:

   ```
   javac *.java
   ```
3. Run the program:

   ```
   java Main
   ```

---

## Project Structure

* `Main.java` → Contains the main logic and menu system
* `Person.java` → Represents each person in the queue
* `PersonComparator.java` → Handles priority logic which uses categorical encoding 
* `data.txt` → Stores queue data

---

## Sample Usage

1. Add multiple people with different types
2. Serve next person → highest priority is served first
3. View queue and statistics

---

## What I Learned

* How PriorityQueue works
* How to implement custom sorting using Comparator
* Basics of file handling in Java
* Designing a simple real-world application

---

## Future Improvements

* Add a graphical interface (GUI)
* Include timestamps for entries
* Improve the user interface

---

## Author
By Srijan Roy
Created as part of Programming in Java (BYOP)
