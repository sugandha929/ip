public class ToDos extends Task {
	public ToDos(String item){
		super(item);
	}

	@Override
	public String getType(){
		return "[T]";
	}
}
