package task;

/**
 * Deadline class is used to create deadline type tasks.
 */
public class Deadline extends Task {
    private String deadlineDate;

    /**
     * constructor class to create a deadline object.
     * @param item the user input.
     * @param deadlineDate the date of the deadline.
     */
    public Deadline(String item, String deadlineDate) {
        super(item);
        this.deadlineDate = deadlineDate;
    }

    /**
     * gets the date of the deadline.
     * @return the date of the deadline object.
     */
    public String getDate() {
        return this.deadlineDate;
    }

    /**
     * specifies which type of task object it is.
     * @return [D] which signifies that this is a deadline object.
     */
    @Override
    public String getType() {
        return "[D]";
    }

    /**
     * to convert deadline object into string.
     * @return the deadline object in a string format, with its description and date.
     */
    @Override
    public String toString() {
        return String.format("%s (by: %s)", this.description, this.deadlineDate);
    }

}
