import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        String[] list=new String[100];
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
            if(line.equalsIgnoreCase("list")){
                for(int x=0; x<i; x++) {
                    int j = x + 1;
                    System.out.println(j + ". " + list[x]);
                }
            }
            else {
                list[i] = line;
                i++;
                System.out.println(line);
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}