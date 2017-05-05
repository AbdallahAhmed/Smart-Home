package Controller;

public class TurnON extends Action {
	public void execute(){
		if(status){
			System.out.println("Light is already turned on");
		}else{
			status = true;
			System.out.println("Light is turned on");
		}
	}
}
