package task;

/**
 * ToDo class is used to create todo type tasks.
 */
public class ToDo extends Task {
    public ToDo(String item) {
        super(item);
    }

    /**
     * specifies which type of task object it is.
     * @return [T] which signifies that this is a todo object.
     */
    @Override
    public String getType() {
        return "[T]";
    }
}
