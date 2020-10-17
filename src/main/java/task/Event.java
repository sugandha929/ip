package task;

/**
 * Event class is used to create event type tasks.
 */
public class Event extends Task {
    private String eventDate;

    /**
     * constructor class to create an event object.
     * @param item the user input.
     * @param eventDate the date of the event.
     */
    public Event(String item, String eventDate) {
        super(item);
        this.eventDate = eventDate;
    }

    /**
     * gets the date of the event.
     * @return the date of the event object.
     */
    public String getDate() {
        return this.eventDate;
    }

    /**
     * specifies which type of task object it is.
     * @return [E] which signifies that this is an event object.
     */
    @Override
    public String getType() {
        return "[E]";
    }

    /**
     * to convert event object into string.
     * @return the event object in a string format, with its description and date.
     */
    @Override
    public String toString() {
        return String.format("%s (at: %s)", this.description, this.eventDate);
    }
}
