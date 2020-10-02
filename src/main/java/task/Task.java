package task;

public class Task {
	protected String description;
	protected String mark;
	protected String type;
	public String getMark(){
		return mark;
	}
	public String getDescription(){
		return description;
	}
	public Task(String item){
		this.mark="[\u2717]";
		this.description =item;
	}
	public void Done(){
		this.mark="[\u2713]";
	}

	@Override
	public String toString(){
		return String.format("%s", this.description);
	}

	public String getType(){
		return this.type;
	}

}
