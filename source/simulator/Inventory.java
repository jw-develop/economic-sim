package simulator;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
	
	private HashMap<String,ArrayList<Good>> goods = new HashMap<String,ArrayList<Good>>();
	
	public int consume(String goodname,int amount) {
		ArrayList<Good> depleted = new ArrayList<Good>();
		ArrayList<Good> consumeables = getGoodList(goodname);
		if (consumeables == null)
			return amount;
		for (Good consuming : consumeables) {
			if (consuming.getQuantity()<=amount) {
				amount -= consuming.getQuantity();
				depleted.add(consuming);
			}
			else {
				consuming.lowerQuantity(amount);
				amount = 0;
			}
		}
		consumeables.removeAll(depleted);
		return amount;
	}
	
	public void acquire(Good good) {
		String nameofgood = good.getNameofGood();
		if (getGoodList(nameofgood)==null)
			goods.put(nameofgood,new ArrayList<Good>());
		ArrayList<Good> listofgoods = getGoodList(nameofgood);
		listofgoods.add(good);
	}
	
	public int getAmtOfGood(String nameofgood) {
		int quantity = 0;
		for (Good thang : getGoodList(nameofgood))
			quantity+=thang.getQuantity();
		return quantity;
	}
	
	public ArrayList<Integer> getAmtOfEachGood(String nameofgood) {
		ArrayList<Integer> quantities = new ArrayList<Integer>();
		for (Good thang : getGoodList(nameofgood))
			quantities.add(thang.getQuantity());
		return quantities;
	}
	
	private ArrayList<Good> getGoodList(String nameofgood) {
		return goods.get(nameofgood);
	}
}
