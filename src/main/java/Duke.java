import exception.CommandException;

import java.io.IOException;

/**
 * The main class for running the application.
 */
public class Duke {


    public Duke() {

    }

    /**
     * greets the user.
     * reads existing file and saves it into a list.
     * returns number of tasks in the previous list.
     *
     * @param args the input from command line.
     * @throws CommandException exception for any invalid commands.
     * @throws IOException exception when there is an error with the file.
     * @throws ClassNotFoundException exception when class name is invalid.
     */

    public static void main(String[] args) throws CommandException, IOException, ClassNotFoundException {
        Ui.greeting();
        int taskIndex = Storage.read("./output.txt",
                Parser.getListOfTasks());
        if (taskIndex == 0) {
            Ui.noItemMessage();
        }
        Parser.parse();
    }

    /**
     * This class handles exceptions.
     * @param userInput the input entered by user in the command line interface.
     */
    public static void executeException(String userInput) {
        if (userInput.contains("todo") || (userInput.contains("todo") && userInput.substring(5).trim().isEmpty())) {
            Ui.todoException();
        } else if (userInput.contains("deadline")) {
            Ui.deadlineException();
        } else if (userInput.contains("event")) {
            Ui.eventException();
        } else {
            Ui.commandException();
        }
    }
}

