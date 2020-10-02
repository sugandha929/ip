import exception.commandException;
import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {

	public static void delete(ArrayList<Task> listOfTasks, String userInput) throws IOException {
		int slashIndex = Integer.parseInt(userInput.substring(7)) - 1;
		Ui.deleteMessage(listOfTasks, slashIndex);
		Storage.save(listOfTasks);
	}

	public static void done(ArrayList<Task> listOfTasks, String userInput) throws IOException {
		int slashIndex = Integer.parseInt(userInput.substring(5)) - 1;
		(listOfTasks.get(slashIndex)).Done();
		Ui.doneMessage(listOfTasks, slashIndex);
		Storage.save(listOfTasks);
	}


	public static void todo(ArrayList<Task> listOfTasks, String userInput) throws IOException {
		String[] todoString=(userInput.split(" ", 2));
		ToDos item = new ToDos(todoString[1]);
		listOfTasks.add(item);
		Storage.save(listOfTasks);
	}


	public static void deadline(ArrayList<Task> listOfTasks, String userInput) throws IOException {
		int slashIndex = userInput.indexOf("by");
		int a;
		if (userInput.contains("/")){
			a = 2;
		}
		else {
			a = 1;
		}
		Deadlines item = new Deadlines(userInput.substring(9, slashIndex - a),
				userInput.substring(slashIndex + 3));
		listOfTasks.add(item);
		Storage.save(listOfTasks);
	}


	public static void event(ArrayList<Task> listOfTasks, String userInput) throws commandException, IOException {
		if (userInput.length() <= 5 || !userInput.contains("event")) {
			throw new commandException();
		}
		int slashIndex = userInput.indexOf("at");
		int a;
		if (userInput.contains("/")){
			a = 2;
		}
		else {
			a = 1;
		}
		Events item = new Events(userInput.substring(6, slashIndex - a),
				userInput.substring(slashIndex + 3));
		listOfTasks.add(item);
		Storage.save(listOfTasks);
	}
	public static void find(ArrayList<Task> listOfTasks, String userInput) {
		String[] findStrings=userInput.split(" ", 2);
		Ui.findMessage();
		for(int index = 0; index < listOfTasks.size(); ++index) {
			int j = index + 1;
			if((listOfTasks.get(index)).toString().contains(findStrings[1])) {
				Ui.findTasks(listOfTasks, j, index);
			}
		}
	}
}
