
package p1;

interface Wifi
{
   public boolean doConnect(String fileName);	
}

class Laptop implements Wifi{

	@Override
	public boolean doConnect(String fileName) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}

public class Task {

	public static void main(String[] args) {
		
		Task app = new Task();
		Wifi wifi = new Laptop();
		app.letsConnect(wifi);
		
		app.letsConnect(new Wifi(){
			@Override
			public boolean doConnect(String fileName) {
				System.out.println("wifi connected");
				return true;
				
			}
	});
}
	
	public void letsConnect(Wifi wifi)
	{
		System.out.println("Wifi connected");
	}
}
