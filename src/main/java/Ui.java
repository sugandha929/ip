


import task.Task;
import task.ToDos;

import java.io.PrintStream;
import java.util.ArrayList;

import java.util.Scanner;
public class Ui {
	public static final Scanner input = new Scanner(System.in);

	public static void greeting() {
		System.out.println("Hello! I am Groot");
		System.out.println("What can I do for you?");
		System.out.println("Please find your previous list items below: ");
	}

	public static void byeMessage() {
		System.out.println("Bye. Hope to see you again soon!");
	}

	public static void listMessage(ArrayList<Task> listOfTasks) {
		System.out.println("Here are the tasks in your list: ");
		for(int index = 0; index < listOfTasks.size(); ++index) {
			int j = index + 1;
			System.out.println(j + "." + ((Task)listOfTasks.get(index)).getType() +
					((Task)listOfTasks.get(index)).getMark() + " " +
					((Task)listOfTasks.get(index)).toString());
		}
	}


	public static void deleteMessage(ArrayList<Task> listOfTasks, int slashIndex) {
		System.out.println("Noted. I've removed this task:\n   " + ((Task)listOfTasks.get(slashIndex)).getType() +
				((Task)listOfTasks.get(slashIndex)).getMark() + " " + listOfTasks.get(slashIndex));
		listOfTasks.remove(slashIndex);
		System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");

	}

	public static void doneMessage(ArrayList<Task> listOfTasks, int slashIndex) {
		System.out.println("Nice! I've marked this task as done:\n   " +
				((Task)listOfTasks.get(slashIndex)).getType() + "[✓] " + listOfTasks.get(slashIndex));
	}

	public static void taskMessage(ArrayList<Task> listOfTasks, int taskIndex) {
		System.out.println("Got it. I've added this task:\n   " +
				((Task)listOfTasks.get(taskIndex)).getType()+
				((Task)listOfTasks.get(taskIndex)).getMark() + " " + listOfTasks.get(taskIndex));
		System.out.println("Now you have " + (taskIndex + 1) + " tasks in the list.");
		++taskIndex;
	}

	public static void listException() {
		System.out.println("☹ OOPS! There are no tasks in your list.");
	}

	public static void deadlineDateException() {
		System.out.println("☹ OOPS! The date of a deadline cannot be empty.");
	}

	public static void eventDateException() {
		System.out.println("☹ OOPS! The date of an event cannot be empty.");
	}
	public static void taskNoException() {
		System.out.println("☹ OOPS! Task number invalid.");
	}

	public static void indexException() {
		System.out.println("☹ OOPS! There is an error.");
	}

	public static void fileIoException() {
		System.out.println("File error");
	}

	public static void noFileException() {
		System.out.println("There was no existing file, so new file created");
	}

	public static void todoException() {
		System.out.println("☹ OOPS! The description of a todo cannot be empty.");
	}

	public static void deadlineException() {
		System.out.println("☹ OOPS! The description of a deadline cannot be empty.");
	}

	public static void eventException() {
		System.out.println("☹ OOPS! The description of an event cannot be empty.");
	}

	public static void commandException() {
		System.out.println("☹ OOPS! command invalid.");
	}
}
