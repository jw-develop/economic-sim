/**
 * 
 */
package simulation;

/**
 * @author jameswhite
 *
 */
public class Good {
	private String nameofgood;
	private int quantity;
	private int age;
	private boolean empty = false;
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
		if (quantity <= 0)
			this.empty = true;
	}
	public int getQuantity() {
		return quantity;
	}
	public boolean isEmpty() {
		return empty;
	}
	public int getValue(int price) {
		return price*quantity+age;
	}
}