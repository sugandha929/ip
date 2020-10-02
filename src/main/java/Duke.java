//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import exception.commandException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

/**
 * The main class for running the application
 */
public class Duke {


    public Duke() {

    }

    /**
     * greets the user
     * reads existing file and saves it into a list
     * returns number of tasks in the previous list
     * @param args
     * @throws commandException
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public static void main(String[] args) throws commandException, IOException, ClassNotFoundException {
        Ui.greeting();
        int taskIndex=Storage.read("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt",
                Parser.getListOfTasks());
        if (taskIndex==0){
            Ui.noItemMessage();
        }
        Parser.parse();
    }

    public static void executeException(String userInput) {
        if (userInput.equals("todo")) {
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

