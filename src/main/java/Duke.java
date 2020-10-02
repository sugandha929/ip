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

public class Duke {


    public Duke() {

    }


    public static void main(String[] args) throws commandException, IOException, ClassNotFoundException {
        Ui.greeting();
        int taskIndex=Storage.read("./output.txt",
                Parser.getListOfTasks());
        if (taskIndex==0){
            Ui.noItemMessage();
        }
        Parser.parse(taskIndex);
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

