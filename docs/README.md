# User Guide

## Introduction 
This application is called Groot. It is a command line application that allows users to store a list of tasks. 

## Setting up 
Prerequisites: Java11
1. Download the jar file from here.
2. Extract the jar file to a root folder you prefer.
3. Open command prompt and change directory to the root folder of the jar file
4. Run this command: java -jar duke.jar

After opening up the application, if there was no error you shoudl see this message:

Hello! I am Groot  
What can I do for you?  
Please find your previous list items below:   
No items

## Features
### Load data
This application automatically loads previously added tasks.   
If there are no previous tasks present it will print: No items. 
### Add Tasks
There are 3 different types of tasks that a user can add:

- todo
- deadline
- event

#### Todo:
To add a todo task type:

todo "description of your task"
(without the double qoutes)

Example of usage: 

`todo clean my room`

Expected outcome:

`Got it. I've added this task:`  
 ` [T][✗] clean my room     `  
 `Now you have 1 tasks in the list.`
 
 #### Deadline:
 To add a deadline task type:
 
 deadline "description of your task" by "your date or time"  
 OR  
 deadline "description of your task" /by "your date or time"
 (without the double qoutes)
 
 Example of usage: 
 
 `deadline finish assignment by 21 oct`
 
 Expected outcome:
 
 `Got it. I've added this task:`  
  ` [D][✗] finish assignment (by: 21 oct)     `  
  `Now you have 2 tasks in the list.`  
  #### Event:
   To add an event task type:
   
   event "description of your task" at "your date or time"  
   OR  
   deadline "description of your task" /at "your date or time"
   (without the double qoutes)
   
   Example of usage: 
   
   `event project meeting at 2 pm`
   
   Expected outcome:
   
   `Got it. I've added this task:`  
    ` [E][✗] project meeting (at: 2 pm)     `  
    `Now you have 3 tasks in the list.`
  ### List all tasks: `list`
  This function shows you your current list of tasks. 
  
  Example of usage: 
   
   `list`
   
   Expected outcome:   
   `Here are the tasks in your list:`   
   `1.[T][✗] clean my room`  
    `2.[D][✗] finish assignment (by: 21 oct)`   
   ` 3.[E][✗] project meeting (at: 2 pm)` 
    
   ### Mark tasks as done: `done`
   This function marks the task number that you specify as done by showing a tick in front of it.   
   
   Example of usage:  
   
   `list`  
 
 Expected outcome:  
 
 `Nice! I've marked this task as done:`   
 `[T][✓] clean my room` 
 
  ### Delete tasks: `delete`
  This function deletes the task number that you specify 
  
  Example of usage:  
     
  `delete 1`  
   
   Expected outcome:  
   
   `Noted. I've removed this task:`   
   `[T][✓] clean my room`   
   `Now you have 2 tasks in the list.`
  ### Find tasks: `find`
  This function finds the task containing the words or letters that the user specifies 
    
  Example of usage:  
       
  `find assignment`  
     
  Expected outcome:  
     
  `Here are the matching tasks in your list: `     
  `1.[D][✗] finish assignment (by: 21 oct)` 
  ### Quit application: `bye`
  This function will quit your application.  
  
  Example of usage:  
         
  `bye`  
       
  Expected outcome:  
       
  `Bye. Hope to see you again soon!` 
  
  ### Save data
  This application automatically saves your tasks in a file, whenever you make changes in your list.
  
  ### Error detection 
  This application will detect any invalid commands, missing descriptions or dates, invalid task numbers and any other errors, and will print messages such as:  
  
  `☹ OOPS! Task number invalid.`   
  
  `☹ OOPS! The description of a deadline cannot be empty.`
  
  `☹ OOPS! The date of an event cannot be empty.`
  
  After printing an error message the application will quit on its own.
  
## Notes 
- All commands are case-sensitive
- Make sure to follow the format given for different commands
- Make sure there are no leading spaces in single word commands
    