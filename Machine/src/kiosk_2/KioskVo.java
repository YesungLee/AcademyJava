package kiosk_2;

public class KioskVo {
	
	String menu;
	int kind, price;
	
	
	
	 public String getMenu() {
		return menu;
	}



	public void setMenu(String menu) {
		this.menu = menu;
	}



	public int getKind() {
		return kind;
	}



	public void setKind(int kind) {
		this.kind = kind;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	  public String toString() {
		 return "OrderedDTO [menu=" + menu + ", kind=" + kind + ", price=" + price + "]";
	 }
	    
}
