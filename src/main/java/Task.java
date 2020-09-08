public class Task {
	protected String item;
	protected String mark;
	protected String type;
	public String getMark(){
		return mark;
	}
	public String getItem(){
		return item;
	}
	public Task(String item){
		this.mark="[\u2717]";
		this.item=item;
	}
	public void Done(){
		this.mark="[\u2713]";
	}

	@Override
	public String toString(){
		return String.format("%s", this.item);
	}

	public String getType(){
		return this.type;
	}

}
