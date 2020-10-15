import exception.commandException;
import task.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parser class translates the user input into commands
 */
public class Parser {
    private static ArrayList<Task> listOfTasks = new ArrayList();

    public static ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * Uses the user input to call methods from classes UI and TaskList
     *
     * @throws IOException
     */
    public static void parse() throws IOException, NumberFormatException {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        while (true) {
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
                } else {

                    if (userInput.length() > 6 && userInput.contains("delete")) {
                        TaskList.delete(listOfTasks, userInput);
                    } else if (userInput.length() > 4 && userInput.contains("done")) {
                        TaskList.done(listOfTasks, userInput);
                    } else if (userInput.length() > 4 && userInput.contains("find")) {
                        TaskList.find(listOfTasks, userInput);
                    } else {
                        if (userInput.length() > 4 && userInput.contains("todo") &&
                                !userInput.substring(5).trim().isEmpty()) {
                            TaskList.todo(listOfTasks, userInput);
                        } else if (userInput.length() > 8 && userInput.contains("deadline")) {
                            TaskList.deadline(listOfTasks, userInput);
                        } else {
                            TaskList.event(listOfTasks, userInput);
                        }
                        Ui.taskMessage(listOfTasks);
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
                    Ui.deadlineException();
                } else if (userInput.contains("event")) {
                    Ui.eventException();
                } else if (userInput.contains("done") || userInput.contains("delete")) {
                    Ui.taskNoException();
                } else {
                    Ui.indexException();
                }
                break;
            } catch (IOException var10) {
                Ui.fileIoException();
                break;
            } catch (NumberFormatException var10) {
                Ui.NumberFormatException();
                break;
            }
        }
    }
}
