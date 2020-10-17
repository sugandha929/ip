package task;

/**
 * Task class is used to create a Task type object.
 */
public class Task {
    protected String description;
    protected String mark;
    protected String type;

    /**
     * gets the mark which signifies if the task is done or not.
     * @return tick mark or a cross mark depending on whether a task is marked as done.
     */
    public String getMark() {
        return mark;
    }

    /**
     * it gets the description of a particular task object.
     * @return the description of a task object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * constructor to create task type objects.
     * @param item the user input.
     */
    public Task(String item) {
        this.mark = "[✗]";
        this.description = item;
    }

    /**
     * marks the task as done.
     */
    public void done() {
        this.mark = "[✓]";
    }

    /**
     * to convert any task object into string.
     * @return the task object in a string format, with its description.
     */
    @Override
    public String toString() {
        return String.format("%s", this.description);
    }

    /**
     * specifies which type of task object it is.
     * @return [D], [E] or [T] depending on particular type of task, over-written by Deadline, Event and Todo classes.
     */
    public String getType() {
        return this.type;
    }

}
