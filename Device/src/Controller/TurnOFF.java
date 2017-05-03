package Controller;

public class TurnOFF extends Action {
	public void execute(){
		if(!status){
			System.out.println("Light is already turned off");
		}else{
			status = false;
			System.out.println("Light is turned off");
		}
	}
}
