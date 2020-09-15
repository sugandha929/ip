//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import exception.commandException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
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
        int taskIndex = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I am Groot");
        System.out.println("What can I do for you?");
        System.out.println("Please find your previous list items below: ");
        read("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
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

                    for(slashIndex = 0; slashIndex < taskIndex; ++slashIndex) {
                        int j = slashIndex + 1;
                        System.out.println(j + "." + ((Task)listOfTasks.get(slashIndex)).getType() + ((Task)listOfTasks.get(slashIndex)).getMark() + " " + ((Task)listOfTasks.get(slashIndex)).toString());
                    }
                } else {
                    PrintStream var10000;
                    String var10001;
                    if (userInput.length() > 4 && userInput.contains("delete")) {
                        slashIndex = Integer.parseInt(userInput.substring(7)) - 1;
                        var10000 = System.out;
                        var10001 = ((Task)listOfTasks.get(slashIndex)).getType();
                        var10000.println("Noted. I've removed this task:\n   " + var10001 + ((Task)listOfTasks.get(slashIndex)).getMark() + " " + listOfTasks.get(slashIndex));
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
                            ToDos item = new ToDos(userInput.substring(5));
                            listOfTasks.add(item);
                            save();
                        } else if (userInput.length() > 8 && userInput.contains("deadline")) {
                            slashIndex = userInput.indexOf("/");
                            Deadlines item = new Deadlines(userInput.substring(9, slashIndex - 1), userInput.substring(slashIndex + 4));
                            listOfTasks.add(item);
                            save();
                        } else {
                            if (userInput.length() <= 5 || !userInput.contains("event")) {
                                throw new commandException();
                            }

                            slashIndex = userInput.indexOf("/");
                            Events item = new Events(userInput.substring(6, slashIndex - 1), userInput.substring(slashIndex + 4));
                            listOfTasks.add(item);
                            save();
                        }

                        var10000 = System.out;
                        var10001 = ((Task)listOfTasks.get(taskIndex)).getType();
                        var10000.println("Got it. I've added this task:\n   " + var10001 + ((Task)listOfTasks.get(taskIndex)).getMark() + " " + listOfTasks.get(taskIndex));
                        System.out.println("Now you have " + (taskIndex + 1) + " tasks in the list.");
                        ++taskIndex;
                    }
                }

                userInput = in.nextLine();
            } catch (commandException var8) {
                executeException(userInput);
                break;
            } catch (IndexOutOfBoundsException var9) {
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
            } catch (IOException var10) {
                System.out.println("File error");
                break;
            }
        }

    }

    public static void save() throws IOException, FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt", true);
            Iterator var1 = listOfTasks.iterator();

            while(var1.hasNext()) {
                Task s = (Task)var1.next();
                String var10001 = ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getType();
                writer.write(var10001 + ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getMark() + listOfTasks.get(listOfTasks.indexOf(s)) + "\n");
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

    public static void read(String fileName) throws IOException, FileNotFoundException {
        try {
            File file = new File(fileName);
            Scanner readfile = new Scanner(file);
            String line = null;

            while(readfile.hasNext()) {
                line = readfile.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException var4) {
            System.out.println("There was no existing file, so new file created");
            FileWriter writer = new FileWriter("/Users/nikki/Documents/GitHub/ip/src/main/java/output.txt");
            writer.close();
        } catch (IOException var5) {
            System.out.println("File error");
        }

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
