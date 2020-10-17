import exception.CommandException;
import task.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parser class translates the user input into commands.
 */
public class Parser {
    private static ArrayList<Task> listOfTasks = new ArrayList();

    public static ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * Uses the user input to call methods from classes UI and TaskList.
     *
     * @throws IOException           exception when there is an error with the file.
     * @throws NumberFormatException exception when numbers are no integers,
     *                               or there are no leading spaces before numbers.
     */
    public static void parse() throws IOException, NumberFormatException {
        while (true) {
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();
            while (!(userInput.equals("bye"))) {
                try {
                    int slashIndex;
                    if (userInput.equalsIgnoreCase("list")) {
                        if (!userInput.equals("list")) {
                            throw new CommandException();
                        }
                        Ui.listMessage(listOfTasks);
                    } else {
                        if (userInput.length() > 6 && userInput.contains("delete")) {
                            TaskList.delete(listOfTasks, userInput);
                        } else if (userInput.length() > 4 && userInput.contains("done")) {
                            TaskList.done(listOfTasks, userInput);
                        } else if (userInput.length() > 4 && userInput.contains("find")) {
                            TaskList.find(listOfTasks, userInput);
                        } else {
                            if (userInput.length() > 4 && userInput.contains("todo")
                                    && !userInput.substring(5).trim().isEmpty()) {
                                TaskList.addTodo(listOfTasks, userInput);
                            } else if (userInput.length() > 8 && userInput.contains("deadline")
                                    && !userInput.substring(userInput.indexOf("/by") + 3).trim().isEmpty()
                                    && !userInput.substring(9, userInput.indexOf("/by")).trim().isEmpty()) {
                                TaskList.addDeadline(listOfTasks, userInput);
                            } else if (userInput.length() > 5 && userInput.contains("event")
                                    && !userInput.substring(userInput.indexOf("at") + 2).trim().isEmpty()
                                    && !userInput.substring(6, userInput.indexOf("/at")).trim().isEmpty()) {
                                TaskList.addEvent(listOfTasks, userInput);
                            } else {
                                throw new CommandException();
                            }
                            Ui.taskMessage(listOfTasks);
                        }
                    }
                    userInput = in.nextLine();
                } catch (CommandException e) {
                    Duke.executeException(userInput);
                    break;
                } catch (IndexOutOfBoundsException e) {
                    if (userInput.contains("list")) {
                        Ui.listException();
                    } else if (userInput.contains("deadline")) {
                        Ui.deadlineException();
                    } else if (userInput.contains("event")) {
                        Ui.eventException();
                    } else if (userInput.contains("done") || userInput.contains("delete")) {
                        Ui.taskNoException();
                    } else {
                        Ui.indexException();
                    }
                    break;
                } catch (IOException e) {
                    Ui.fileIoException();
                    break;
                } catch (NumberFormatException e) {
                    Ui.numberFormatException();
                    break;
                }
            }
            if (userInput.equalsIgnoreCase("bye")) {
                Ui.byeMessage();
                break;
            }
        }
    }
}
