//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import exception.commandException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

public class Duke {
    private static ArrayList<Task> listOfTasks = new ArrayList();

    public Duke() {
    }


    public static void main(String[] args) throws commandException, IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I am Groot");
        System.out.println("What can I do for you?");
        System.out.println("Please find your previous list items below: ");
        int taskIndex=read("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
        String userInput = in.nextLine();

        while(true) {
            try {
                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                }

                int slashIndex;
                if (userInput.equalsIgnoreCase("list")) {
                    if (!userInput.equals("list")) {
                        throw new commandException();
                    }

                    System.out.println("Here are the tasks in your list: ");

                    for(int index = 0; index < listOfTasks.size(); ++index) {
                        int j = index + 1;
                        System.out.println(j + "." + ((Task)listOfTasks.get(index)).getType() +
                                ((Task)listOfTasks.get(index)).getMark() + " " +
                                ((Task)listOfTasks.get(index)).toString());
                    }
                } else {
                    PrintStream var10000;
                    String var10001;
                    if (userInput.length() > 4 && userInput.contains("delete")) {
                        slashIndex = Integer.parseInt(userInput.substring(7)) - 1;
                        var10000 = System.out;
                        var10001 = ((Task)listOfTasks.get(slashIndex)).getType();
                        var10000.println("Noted. I've removed this task:\n   " + var10001 +
                                ((Task)listOfTasks.get(slashIndex)).getMark() + " " + listOfTasks.get(slashIndex));
                        listOfTasks.remove(slashIndex);
                        System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                        save();
                    } else if (userInput.length() > 4 && userInput.contains("done")) {
                        slashIndex = Integer.parseInt(userInput.substring(5)) - 1;
                        ((Task)listOfTasks.get(slashIndex)).Done();
                        var10000 = System.out;
                        var10001 = ((Task)listOfTasks.get(slashIndex)).getType();
                        var10000.println("Nice! I've marked this task as done:\n   " + var10001 + "[✓] " + listOfTasks.get(slashIndex));
                        save();
                    } else {
                        if (userInput.length() > 4 && userInput.contains("todo")) {
                            String[] todoString=(userInput.split(" ", 2));
                            ToDos item = new ToDos(todoString[1]);
                            listOfTasks.add(item);
                            System.out.println(item.getDescription());
                            save();
                        } else if (userInput.length() > 8 && userInput.contains("deadline")) {
                            slashIndex = userInput.indexOf("by");
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
                            save();
                        } else {
                            if (userInput.length() <= 5 || !userInput.contains("event")) {
                                throw new commandException();
                            }
                            slashIndex = userInput.indexOf("at");
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
                            save();
                        }

                        var10000 = System.out;
                        var10001 = ((Task)listOfTasks.get(taskIndex)).getType();
                        var10000.println("Got it. I've added this task:\n   " + var10001 +
                                ((Task)listOfTasks.get(taskIndex)).getMark() + " " + listOfTasks.get(taskIndex));
                        System.out.println("Now you have " + (taskIndex + 1) + " tasks in the list.");
                        ++taskIndex;
                    }
                }

                userInput = in.nextLine();
            } catch (commandException var8) {
                executeException(userInput);
                break;
            } /*catch (IndexOutOfBoundsException var9) {
                if (userInput.contains("list")) {
                    System.out.println("☹ OOPS! There are no tasks in your list.");
                } else if (userInput.contains("deadline")) {
                    System.out.println("☹ OOPS! The date of a deadline cannot be empty.");
                } else if (userInput.contains("event")) {
                    System.out.println("☹ OOPS! The date of an event cannot be empty.");
                } else {
                    System.out.println("☹ OOPS! Task number invalid.");
                }
                break;
            }*/ catch (IOException var10) {
                System.out.println("File error");
                break;
            }
        }

    }

    public static void save() throws IOException, FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
            Iterator var1 = listOfTasks.iterator();

            while(var1.hasNext()) {
                Task s = (Task)var1.next();
                String var10001 = ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getType();
                writer.write(var10001 + ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getMark() +
                        listOfTasks.get(listOfTasks.indexOf(s)) + "\n");
            }

            writer.close();

        } catch (FileNotFoundException var4) {
            System.out.println("There was no existing file, so new file created");
            FileWriter writer = new FileWriter("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
            writer.close();
        } catch (IOException var5) {
            System.out.println("File error");
        }

    }

    public static int read(String fileName) throws IOException, FileNotFoundException {
        int taskIndex=0;
        try {
            File file = new File(fileName);
            Scanner readfile = new Scanner(file);
            String line = null;
            int dateIndex;
            while(readfile.hasNext()) {
                line = readfile.nextLine();
                if (line.contains("[T]")){
                    ToDos item=new ToDos(line.substring(6));
                    listOfTasks.add(item);
                }
                else if(line.contains("[D]")){
                    dateIndex = line.indexOf("(");
                    Deadlines item = new Deadlines(line.substring(6, dateIndex - 1),
                            line.substring(dateIndex + 5, line.length()-1));
                    listOfTasks.add(item);
                }
                else{
                    dateIndex = line.indexOf("(");
                    Events item = new Events(line.substring(6, dateIndex - 1),
                            line.substring(dateIndex + 4, line.length()-1));
                    listOfTasks.add(item);
                }
                if(line.substring(4, 5).equals("✓")){
                    listOfTasks.get(taskIndex).Done();
                }
                System.out.println(line);
                taskIndex++;
            }

        } catch (FileNotFoundException var4) {
            System.out.println("There was no existing file, so new file created");
            FileWriter writer = new FileWriter("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
            writer.close();
        } catch (IOException var5) {
            System.out.println("File error");
        }
        return taskIndex;
    }

    public static void executeException(String input) {
        if (input.equals("todo")) {
            System.out.println("☹ OOPS! The description of a todo cannot be empty.");
        } else if (input.contains("deadline")) {
            System.out.println("☹ OOPS! The description of a deadline cannot be empty.");
        } else if (input.contains("event")) {
            System.out.println("☹ OOPS! The description of an event cannot be empty.");
        } else {
            System.out.println("☹ OOPS! command invalid.");
        }

    }
}
/* private static void saveTask(List<Task> list) throws IOException{
        FileWriter fileWriter = new FileWriter(FILENAME);
        for(Task task : list){
            if(task instanceof Todo){
                fileWriter.write("T | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + "\n");
            }else if(task instanceof Deadline){
                String[] deadline =  task.description.split("/by");
                fileWriter.write("D | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + " | " + ((Deadline) task).by + "\n");
            }else if(task instanceof Event) {
                fileWriter.write("E | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + " | " + ((Event) task).at + "\n");
            }
        }
        fileWriter.close();
    }

 */