import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Storage class creates and saves the list as a file.
 * It also reads and saves data into a list from the file.
 */
public class Storage {
    /**
     * Creates a file and saves the task list.
     *
     * @param listOfTasks the complete list of tasks added by the user.
     * @throws IOException exception if there is an error with the file.
     * @throws FileNotFoundException exception if the file does not exist.
     */
    public static void save(ArrayList<Task> listOfTasks) throws IOException, FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("./output.txt");
            Iterator iterator = listOfTasks.iterator();

            while (iterator.hasNext()) {
                Task s = (Task) iterator.next();
                writer.write(((Task) listOfTasks.get(listOfTasks.indexOf(s))).getType()
                        + ((Task) listOfTasks.get(listOfTasks.indexOf(s))).getMark()
                        + listOfTasks.get(listOfTasks.indexOf(s)) + "\n");
            }

            writer.close();

        } catch (FileNotFoundException e) {
            Ui.noFileException();
            FileWriter writer = new FileWriter("./output.txt");
            writer.close();
        } catch (IOException e) {
            Ui.fileIoException();
        }

    }

    /**
     * Reads and saves the data into list of Tasks.
     *
     * @param fileName the path of the file to read from.
     * @param listOfTasks the complete list of tasks added by the user.
     * @return the number of tasks already present in the text file.
     * @throws IOException exception if there is an error with the file.
     * @throws FileNotFoundException exception if the file does not exist.
     */
    public static int read(String fileName, ArrayList<Task> listOfTasks) throws IOException, FileNotFoundException {
        int taskIndex = 0;
        try {
            File file = new File(fileName);
            Scanner readfile = new Scanner(file);
            String line = null;
            int dateIndex;
            while (readfile.hasNext()) {
                line = readfile.nextLine();
                if (line.contains("[T]")) {
                    ToDo item = new ToDo(line.substring(6));
                    listOfTasks.add(item);
                } else if (line.contains("[D]")) {
                    dateIndex = line.indexOf("(");
                    Deadline item = new Deadline(line.substring(6, dateIndex - 1),
                            line.substring(dateIndex + 5, line.length() - 1));
                    listOfTasks.add(item);
                } else {
                    dateIndex = line.indexOf("(");
                    Event item = new Event(line.substring(6, dateIndex - 1),
                            line.substring(dateIndex + 5, line.length() - 1));
                    listOfTasks.add(item);
                }
                if (line.substring(4, 5).equals("✓")) {
                    listOfTasks.get(taskIndex).done();
                }
                System.out.println(line);
                taskIndex++;
            }

        } catch (FileNotFoundException e) {
            Ui.noFileException();
            FileWriter writer = new FileWriter("./output.txt");
            writer.close();
        } catch (IOException e) {
            Ui.fileIoException();
        }
        return taskIndex;
    }
}
