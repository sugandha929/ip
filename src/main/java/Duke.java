import exception.commandException;

import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> listOfTasks = new ArrayList<>();
    public static void main (String[] args) throws commandException {
        String userInput;
        int taskIndex=0;
        Scanner in = new Scanner(System.in);

        System.out.println("Hello! I am Groot");
        System.out.println("What can I do for you?");

        userInput = in.nextLine();

        try {
            while (!userInput.equalsIgnoreCase("bye")) {

                if (!userInput.equalsIgnoreCase("list")) {

                    if (userInput.length() > 4 && userInput.contains("delete")) {
                        int deleteTaskNo = Integer.parseInt(userInput.substring(7)) - 1;
                        System.out.println("Noted. I've removed this task:\n   " +
                                listOfTasks.get(deleteTaskNo).getType() + listOfTasks.get(deleteTaskNo).getMark() +" "
                                + listOfTasks.get(deleteTaskNo));
                        listOfTasks.remove(deleteTaskNo);
                        System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                    }

                    else if (userInput.length() > 4 && userInput.contains("done")) {
                        int doneTaskNo = Integer.parseInt(userInput.substring(5)) - 1;
                        listOfTasks.get(doneTaskNo).Done();
                        System.out.println("Nice! I've marked this task as done:\n   "
                                + listOfTasks.get(doneTaskNo).getType() + "[\u2713] " + listOfTasks.get(doneTaskNo));
                    } else {

                        if (userInput.length() > 4 && userInput.contains("todo")) {
                            ToDos item = new ToDos(userInput.substring(5));
                            listOfTasks.add(item);
                        } else if (userInput.length() > 8 && userInput.contains("deadline")) {
                            int slashIndex = userInput.indexOf("/");
                            Deadlines item = new Deadlines(userInput.substring(9, (slashIndex - 1)),
                                    userInput.substring(slashIndex + 4));
                            listOfTasks.add(item);
                        } else if (userInput.length() > 5 && userInput.contains("event")) {
                            int slashIndex = userInput.indexOf("/");
                            Events item = new Events(userInput.substring(6, (slashIndex - 1)),
                                    userInput.substring(slashIndex + 4));
                            listOfTasks.add(item);
                        }
                        else {
                            throw new commandException();
                        }

                        System.out.println("Got it. I've added this task:\n   "
                        + listOfTasks.get(taskIndex).getType() + listOfTasks.get(taskIndex).getMark() +
                                " " + listOfTasks.get(taskIndex));
                        System.out.println("Now you have " + (taskIndex + 1) + " tasks in the list.");
                        taskIndex++;
                    }

                } else if (userInput.equals("list")){
                    System.out.println("Here are the tasks in your list: ");
                    for (int x = 0; x < taskIndex; x++) {
                        int j = x + 1;
                        System.out.println(j + "." + listOfTasks.get(x).getType() + listOfTasks.get(x).getMark() +
                                " " + listOfTasks.get(x).toString());
                    }
                } else{
                    throw new commandException();
                }
                userInput = in.nextLine();
            }

            System.out.println("Bye. Hope to see you again soon!");
        } catch (commandException e){
            executeException(userInput);
        } catch (IndexOutOfBoundsException e){
            if(userInput.contains("list")){
                System.out.println("☹ OOPS! There are no tasks in your list.");
            } else if (userInput.contains("deadline")){
                System.out.println("☹ OOPS! The date of a deadline cannot be empty.");
            } else if (userInput.contains("event")){
                System.out.println("☹ OOPS! The date of an event cannot be empty.");
            } else {
                System.out.println("☹ OOPS! Task number invalid.");
            }
        }
    }

    public static void executeException(String input){
        if (input.equals("todo")){
            System.out.println("☹ OOPS! The description of a todo cannot be empty.");
        }
        else if(input.contains("deadline")){
            System.out.println("☹ OOPS! The description of a deadline cannot be empty.");
        }
        else if(input.contains("event")){
            System.out.println("☹ OOPS! The description of an event cannot be empty.");
        }
        else{
            System.out.println("☹ OOPS! command invalid.");
        }
    }

}