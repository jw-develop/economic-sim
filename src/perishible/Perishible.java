/**
 * 
 */
package perishible;

/**
 * @author jameswhite
 *
 */
public class Perishible {
	int quantity;
	public Perishible(int q) {
		this.quantity = q;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}