/**
 * 
 */
package game;

/**
 * @author jameswhite
 *
 */
public class Good {
	String nameofgood;
	int quantity;
	int age;
	public Good(String nameofgood,int q) {
		this.nameofgood = nameofgood;
		this.quantity = q;
		age=0;
	}
	
	public String getNameofGood() {
		return nameofgood;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public int getValue(int price) {
		return price*quantity;
	}
}