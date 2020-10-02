package task;

public class Deadlines extends Task {
	private String deadlineDate;
	public Deadlines(String item, String deadlineDate){
		super(item);
		this.deadlineDate=deadlineDate;
	}

	public String getDate(){
		return this.deadlineDate;
	}

	@Override
	public String getType(){
		return "[D]";
	}

	@Override
	public String toString(){
		return String.format("%s (by: %s)", this.description, this.deadlineDate);
	}

}
