package Controller;

public class TurnON extends Action {
	public void execute(){
		if(status){
			System.out.println("TV is already turned on");
		}else{
			status = true;
			System.out.println("TV is turned on");
		}
	}
}
