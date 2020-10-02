import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Storage {
	public static void save(ArrayList<Task> listOfTasks) throws IOException, FileNotFoundException {
		try {
			FileWriter writer = new FileWriter("./output.txt");
			Iterator var1 = listOfTasks.iterator();

			while(var1.hasNext()) {
				Task s = (Task)var1.next();
				String var10001 = ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getType();
				writer.write(var10001 + ((Task)listOfTasks.get(listOfTasks.indexOf(s))).getMark() +
						listOfTasks.get(listOfTasks.indexOf(s)) + "\n");
			}

			writer.close();

		} catch (FileNotFoundException var4) {
			Ui.noFileException();
			FileWriter writer = new FileWriter("./output.txt");
			writer.close();
		} catch (IOException var5) {
			Ui.fileIoException();
		}

	}
	public static int read(String fileName, ArrayList<Task> listOfTasks) throws IOException, FileNotFoundException {
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
			Ui.noFileException();
			FileWriter writer = new FileWriter("./output.txt");
			writer.close();
		} catch (IOException var5) {
			Ui.fileIoException();
		}
		return taskIndex;
	}
}
