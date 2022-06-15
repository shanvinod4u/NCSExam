package p1;

interface Chargable {
	
	public boolean doCharge(String name);
}

class Device implements Chargable {

	@Override
	public boolean doCharge(String name) {
		return false;
	}
	
}

public class Task2 {
	
	public static void main(String[] args) {
		
		Task2 app = new Task2();
		Chargable a = new Device();
		
		app.letsCharge(
				(String Laptop) -> {
					if(a.equals("Laptop")) {
						return true;
					}else return false;
				}
				);
		
	}
	
	public void letsCharge(Chargable charge) {
		charge.doCharge("Laptop");
	}

}
