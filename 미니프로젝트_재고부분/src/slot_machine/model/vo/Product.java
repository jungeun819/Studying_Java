package slot_machine.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 123244142141414L;
	private static final String ID = "mango";
	private static final String PASSWORD = "12345";
//	private String kind;
	private String name;
	private int price;
	private int stock;
	
	
	public Product() {
		super();
	}

	public Product(String name, int price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		
		Product other = (Product) obj;
		if(name == null) {
			if(other.name != null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		
		if(price != other.price)
			return false;
		
		if(stock != other.stock)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return  name + "\t" + price + "\t" + stock + "\t";
	}

	public static String getId() {
		return ID;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	
}
