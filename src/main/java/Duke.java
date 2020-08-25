import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        String[][] list=new String[100][100];
        int i=0;
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        System.out.println("Hello! I'm Groot");
        System.out.println("What can I do for you?");
        line = in.nextLine();
        while(!line.equalsIgnoreCase("bye")){
            if(!line.equalsIgnoreCase("list")){
                if(line.length()>4&&line.contains("done")){
                    int a=Integer.parseInt(line.substring(5));
                    a=a-1;
                    list[0][a]="\u2713";
                    System.out.println("Nice! I've marked this task as done:\n"+"\u2713 "+list[1][a]);
                }
                else {
                    list[1][i] = line;
                    list[0][i] = "\u2717";
                    i++;
                    System.out.println(line);
                }
            }
            else {
                System.out.println("Here are the tasks in your list: ");
                for (int x = 0; x < i; x++) {
                    int j = x + 1;
                    System.out.println(j + "." + list[0][x] + " " + list[1][x]);
                }
            }

            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}