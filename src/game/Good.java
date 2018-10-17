/**
 * 
 */
package game;

/**
 * @author jameswhite
 *
 */
public class Good {
	private String nameofgood;
	private int quantity;
	private int age;
	public Good(String nameofgood,int q) {
		this.nameofgood = nameofgood;
		this.quantity = q;
		age=0;
	}
	
	public String getNameofGood() {
		return nameofgood;
	}
	public void lowerQuantity(int taken) {
		quantity -= taken;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getValue(int price) {
		return price*quantity+age;
	}
}