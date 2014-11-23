package shop.domain;


public class ChoiceMenu {

	protected int mno;
	protected String menuName;
	protected int price;
	protected int num;
	protected boolean choice;
	
	public ChoiceMenu(int mno, String menuName, int price, int num, boolean choice) {
		this.mno = mno;
		this.menuName = menuName;
		this.price = price;
		this.num = num;
		this.choice = choice;
	}
	public ChoiceMenu() {}

	@Override
	public String toString() {
		return "ChoiceMenu [mno=" + mno + ", menuName=" + menuName + ", price="
				+ price + ", num=" + num + ", choice=" + choice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (choice ? 1231 : 1237);
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + mno;
		result = prime * result + num;
		result = prime * result + price;
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
		ChoiceMenu other = (ChoiceMenu) obj;
		if (choice != other.choice)
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (mno != other.mno)
			return false;
		if (num != other.num)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean choice) {
		this.choice = choice;
	}
}
