public class Task {
	private String item;
	private String mark;
	public String getMark(){
		return mark;
	}
	public String getItem(){
		return item;
	}
	public Task(String item){
		this.mark="\u2717";
		this.item=item;
	}
	public void Done(){
		this.mark="\u2713";
	}
}
