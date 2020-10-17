import exception.CommandException;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * TaskList class implements each user input, as translated from Parser class.
 */
public class TaskList {
    /**
     * deletes the task number specified.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws IOException exception if there is en error with the file.
     */
    public static void delete(ArrayList<Task> listOfTasks, String userInput) throws IOException {
        int slashIndex = Integer.parseInt(userInput.substring(7)) - 1;
        Ui.deleteMessage(listOfTasks, slashIndex);
        Storage.save(listOfTasks);
    }

    /**
     * marks the task number specified by user as done.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws IOException exception if there is en error with the file.
     */
    public static void done(ArrayList<Task> listOfTasks, String userInput) throws IOException {
        int slashIndex = Integer.parseInt(userInput.substring(5)) - 1;
        (listOfTasks.get(slashIndex)).done();
        Ui.doneMessage(listOfTasks, slashIndex);
        Storage.save(listOfTasks);
    }

    /**
     * adds a "todo" task in the list of tasks.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws IOException exception if there is en error with the file.
     */
    public static void addTodo(ArrayList<Task> listOfTasks, String userInput) throws IOException {
        String[] todoString = (userInput.split(" ", 2));
        ToDo item = new ToDo(todoString[1]);
        listOfTasks.add(item);
        Storage.save(listOfTasks);
    }

    /**
     * adds a "deadline" task in the list of tasks.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws IOException exception if there is en error with the file.
     */
    public static void addDeadline(ArrayList<Task> listOfTasks, String userInput) throws IOException {
        int slashIndex = userInput.indexOf("/");
        Deadline item = new Deadline(userInput.substring(9, slashIndex - 2),
                userInput.substring(slashIndex + 3));
        listOfTasks.add(item);
        Storage.save(listOfTasks);
    }

    /**
     * adds an "event" task in the list of tasks.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws CommandException exception if a command is invalid.
     * @throws IOException exception if there is an error with the file.
     */
    public static void addEvent(ArrayList<Task> listOfTasks, String userInput) throws CommandException, IOException {
        if (userInput.length() <= 5 || !userInput.contains("event")) {
            throw new CommandException();
        }
        int slashIndex = userInput.indexOf("/");
        Event item = new Event(userInput.substring(6, slashIndex - 2),
                userInput.substring(slashIndex + 3));
        listOfTasks.add(item);
        Storage.save(listOfTasks);
    }

    /**
     * finds any matching items in the list of tasks.
     * @param listOfTasks the complete list of tasks added by the user.
     * @param userInput the string input by the user in the command line.
     * @throws CommandException exception if a command is invalid.
     */
    public static void find(ArrayList<Task> listOfTasks, String userInput) throws CommandException {
        String[] findStrings = userInput.split(" ", 2);
        if (findStrings[1].isEmpty()) {
            throw new CommandException();
        } else {
            Ui.findMessage();
            for (int index = 0; index < listOfTasks.size(); ++index) {
                int j = index + 1;
                if ((listOfTasks.get(index).getDescription()).toString().contains(findStrings[1])) {
                    Ui.findTasks(listOfTasks, j, index);
                }
            }
        }
    }
}
