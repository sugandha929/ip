import exception.commandException;
import task.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	private static ArrayList<Task> listOfTasks = new ArrayList();
	public static ArrayList<Task> getListOfTasks(){
		return listOfTasks;
	}
	public static void parse(int taskIndex) throws IOException {
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		while(true) {
			try {
				if (userInput.equalsIgnoreCase("bye")) {
					Ui.byeMessage();
					break;
				}

				int slashIndex;
				if (userInput.equalsIgnoreCase("list")) {
					if (!userInput.equals("list")) {
						throw new commandException();
					}
					Ui.listMessage(listOfTasks);
				} else if (userInput.length() > 4 && userInput.contains("find")) {
					TaskList.find(listOfTasks, userInput);
				} else{

					if (userInput.length() > 6 && userInput.contains("delete")) {
						TaskList.delete(listOfTasks, userInput);
					} else if (userInput.length() > 4 && userInput.contains("done")) {
						TaskList.done(listOfTasks, userInput);
					} else {
						if (userInput.length() > 4 && userInput.contains("todo")) {
							TaskList.todo(listOfTasks, userInput);
						} else if (userInput.length() > 8 && userInput.contains("deadline")) {
							TaskList.deadline(listOfTasks, userInput);
						} else {
							TaskList.event(listOfTasks, userInput);
						}
						Ui.taskMessage(listOfTasks, taskIndex);
					}
				}
				userInput = in.nextLine();
			} catch (commandException var8) {
				Duke.executeException(userInput);
				break;
			} catch (IndexOutOfBoundsException var9) {
				if (userInput.contains("list")) {
					Ui.listException();
				} else if (userInput.contains("deadline")) {
					Ui.deadlineDateException();
				} else if (userInput.contains("event")) {
					Ui.eventDateException();
				} else if (userInput.contains("done")||userInput.contains("delete")) {
					Ui.taskNoException();
				} else {
					Ui.indexException();
				}
				break;
			} catch (IOException var10) {
				Ui.fileIoException();
				break;
			}
		}

	}

}
