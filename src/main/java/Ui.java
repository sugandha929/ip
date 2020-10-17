import task.Task;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Ui class has all the functions related to the user interface.
 */
public class Ui {
    public static final Scanner input = new Scanner(System.in);

    /**
     * prints the greeting message.
     */
    public static void greeting() {
        System.out.println("Hello! I am Groot");
        System.out.println("What can I do for you?");
        System.out.println("Please find your previous list items below: ");
    }

    /**
     * prints the bye message.
     */
    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * prints the list of all tasks.
     * @param listOfTasks the complete list of tasks entered by the user.
     */
    public static void listMessage(ArrayList<Task> listOfTasks) {
        System.out.println("Here are the tasks in your list: ");
        for (int index = 0; index < listOfTasks.size(); ++index) {
            int j = index + 1;
            System.out.println(j + "." + ((Task) listOfTasks.get(index)).getType()
                    + ((Task) listOfTasks.get(index)).getMark() + " "
                    + ((Task) listOfTasks.get(index)).toString());
        }
    }

    /**
     * prints the message when a task is deleted, along with the task that is deleted.
     * @param listOfTasks the complete list of tasks entered by the user.
     * @param slashIndex the index of "/" in the input entered by the user,
     *                   used to specify the position of date of event or deadline
     */
    public static void deleteMessage(ArrayList<Task> listOfTasks, int slashIndex) {
        System.out.println("Noted. I've removed this task:\n   " + ((Task) listOfTasks.get(slashIndex)).getType()
                + ((Task) listOfTasks.get(slashIndex)).getMark() + " " + listOfTasks.get(slashIndex));
        listOfTasks.remove(slashIndex);
        System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");

    }

    /**
     * prints the message when a task is marked as done, along with the task that is marked as done.
     * @param listOfTasks the complete list of tasks entered by the user.
     * @param slashIndex the index of "/" in the input entered by the user,
     *                   used to specify the position of date of event or deadline
     */
    public static void doneMessage(ArrayList<Task> listOfTasks, int slashIndex) {
        System.out.println("Nice! I've marked this task as done:\n   "
                + ((Task) listOfTasks.get(slashIndex)).getType() + "[✓] " + listOfTasks.get(slashIndex));
    }

    /**
     * prints the message whenever a todo, deadline or event task is added,
     * along with the task, and total number of tasks.
     * @param listOfTasks the complete list of tasks entered by the user.
     */
    public static void taskMessage(ArrayList<Task> listOfTasks) {
        System.out.println("Got it. I've added this task:\n   "
                + ((Task) listOfTasks.get(listOfTasks.size() - 1)).getType()
                + ((Task) listOfTasks.get(listOfTasks.size() - 1)).getMark() + " "
                + listOfTasks.get(listOfTasks.size() - 1));
        System.out.println("Now you have " + (listOfTasks.size()) + " tasks in the list.");
    }

    /**
     * prints the error message when there are no items in the list.
     */
    public static void listException() {
        System.out.println("☹ OOPS! There are no tasks in your list.");
    }

    /**
     * prints the error message when the task number specified by the user is invalid or out of bounds.
     */
    public static void taskNoException() {
        System.out.println("☹ OOPS! Task number invalid.");
    }

    /**
     * prints an error message when there is an index exception.
     */
    public static void indexException() {
        System.out.println("☹ OOPS! There is an error.");
    }

    /**
     * prints an error message if there is an error with the tezt file.
     */
    public static void fileIoException() {
        System.out.println("File error");
    }

    /**
     * prints an error message if the text file does not exist.
     */
    public static void noFileException() {
        System.out.println("There was no existing file, so new file created");
    }

    /**
     * prints an error message when there is no description entered by the user for a todo task.
     */
    public static void todoException() {
        System.out.println("☹ OOPS! The description of a todo cannot be empty.");
    }

    /**
     * prints an error message when there is no description or date entered by the user for a deadline task.
     */
    public static void deadlineException() {
        System.out.println("☹ OOPS! The description or date of a deadline cannot be empty.");
    }

    /**
     * prints an error message when there is no description or date entered by the user for an event task.
     */
    public static void eventException() {
        System.out.println("☹ OOPS! The description or date of an event cannot be empty.");
    }

    /**
     * prints an error message if an unidentified command is entered.
     */
    public static void commandException() {
        System.out.println("☹ OOPS! command invalid.");
    }

    /**
     * prints the message if there are no existing tasks in the list.
     */
    public static void noItemMessage() {
        System.out.println("No items");
    }

    /**
     * prints the message when finding tasks matching the user input.
     */
    public static void findMessage() {
        System.out.println("Here are the matching tasks in your list: ");
    }

    /**
     * prints the tasks matching the user input, when user enters the command "find".
     * @param listOfTasks the complete list of tasks entered by the user.
     * @param j the task number from list of tasks.
     * @param index the index of the task from the list of tasks.
     */
    public static void findTasks(ArrayList<Task> listOfTasks, int j, int index) {
        System.out.println(j + "." + ((Task) listOfTasks.get(index)).getType()
                + ((Task) listOfTasks.get(index)).getMark() + " "
                + ((Task) listOfTasks.get(index)).toString());
    }

    /**
     * prints the error message if number entered is not an integer or does not have leading spaces.
     */
    public static void numberFormatException() {
        System.out.println("☹ OOPS! no spaces found or number invalid.");
    }
}
