package task;

public class Events extends Task {
	private String eventDate;
	public Events(String item, String eventDate){
		super(item);
		this.eventDate=eventDate;
	}

	public String getDate(){
		return this.eventDate;
	}

	@Override
	public String getType(){
		return "[E]";
	}

	@Override
	public String toString(){
		return String.format("%s (at: %s)", this.item, this.eventDate);
	}
}
