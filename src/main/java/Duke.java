import java.util.Scanner;
public class Duke {
    public static void main (String[] args) throws commandException{
        String userInput;
        int taskIndex=0;
        Scanner in = new Scanner(System.in);
        Task[] listOfTasks=new Task[100];
        System.out.println("Hello! I'm Groot");
        System.out.println("What can I do for you?");
        userInput = in.nextLine();
        try {
            while (!userInput.equalsIgnoreCase("bye")) {
                if (!userInput.equalsIgnoreCase("list")) {
                    if (userInput.length() > 4 && userInput.contains("done")) {
                        int doneTaskNo = Integer.parseInt(userInput.substring(5)) - 1;
                        listOfTasks[doneTaskNo].Done();
                        System.out.println("Nice! I've marked this task as done:\n" + "[\u2713] " +
                                listOfTasks[doneTaskNo]);
                    } else {
                        if (userInput.length() > 4 && userInput.contains("todo")) {
                            ToDos item = new ToDos(userInput.substring(5));
                            listOfTasks[taskIndex] = item;
                        } else if (userInput.length() > 8 && userInput.contains("deadline")) {
                            int slashIndex = userInput.indexOf("/");
                            Deadlines item = new Deadlines(userInput.substring(9, (slashIndex - 1)),
                                    userInput.substring(slashIndex + 4));
                            listOfTasks[taskIndex] = item;
                        } else if (userInput.length() > 5 && userInput.contains("event")) {
                            int slashIndex = userInput.indexOf("/");
                            Events item = new Events(userInput.substring(6, (slashIndex - 1)),
                                    userInput.substring(slashIndex + 4));
                            listOfTasks[taskIndex] = item;
                        }
                        else {
                            throw new commandException();
                        }

                        System.out.println("Got it. I've added this task: ");
                        System.out.println(listOfTasks[taskIndex].getType() + listOfTasks[taskIndex].getMark() +
                                " " + listOfTasks[taskIndex]);
                        System.out.println("Now you have " + (taskIndex + 1) + " tasks in the list.");
                        taskIndex++;
                    }
                } else if (userInput.equals("list")){
                    System.out.println("Here are the tasks in your list: ");
                    for (int x = 0; x < taskIndex; x++) {
                        int j = x + 1;
                        System.out.println(j + "." + listOfTasks[x].getType() + listOfTasks[x].getMark() +
                                " " + listOfTasks[x].toString());
                    }
                }
                else{
                    throw new commandException();
                }
                userInput = in.nextLine();
            }
            System.out.println("Bye. Hope to see you again soon!");
        }
        catch (commandException e){
            executeException(userInput);
        }

    }
    public static void executeException(String input){
        if (input.equals("todo")){
            System.out.println("☹ OOPS! The description of a todo cannot be empty.");
        }
        else if(input.equals("deadline")){
            System.out.println("☹ OOPS! The description of a deadline cannot be empty.");
        }
        else if(input.equals("event")){
            System.out.println("☹ OOPS! The description of a event cannot be empty.");
        }
        else{
            System.out.println("☹ OOPS! command invalid.");
        }
    }
}