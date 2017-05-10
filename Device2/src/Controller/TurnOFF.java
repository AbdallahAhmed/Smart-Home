package Controller;

public class TurnOFF extends Action {
	public void execute(){
		if(!status){
			System.out.println("TV is already turned off");
		}else{
			status = false;
			System.out.println("TV is turned off");
		}
	}
}
