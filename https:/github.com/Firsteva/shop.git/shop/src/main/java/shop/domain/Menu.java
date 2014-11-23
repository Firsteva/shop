package shop.domain;

public class Menu {

	protected int no;
	protected String name;
	protected int price;
	protected String reg_date;
	
	@Override
	public String toString() {
		return "Menu [no=" + no + ", name=" + name + ", price=" + price
				+ ", reg_date=" + reg_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + price;
		result = prime * result + ((reg_date == null) ? 0 : reg_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (price != other.price)
			return false;
		if (reg_date == null) {
			if (other.reg_date != null)
				return false;
		} else if (!reg_date.equals(other.reg_date))
			return false;
		return true;
	}

	
	public Menu() {}
	
	public Menu(int no, String name, int price, String reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.reg_date = reg_date;
	}
	
	
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
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
	
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
