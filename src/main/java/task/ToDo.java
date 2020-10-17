package task;

public class ToDo extends Task {
    public ToDo(String item) {
        super(item);
    }

    @Override
    public String getType() {
        return "[T]";
    }
}
