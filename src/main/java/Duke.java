//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import exception.commandException;

import java.io.*;
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
        int taskIndex=Storage.read("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt",
                Parser.getListOfTasks());
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

