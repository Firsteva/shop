package shop.domain;

public class Order {
	
	protected int ono;
	protected int tno;
	protected int mno;
	protected int num;
	protected String order_Date;
	protected int ostatus;
	
	public Order() {}

	public Order(int ono, int tno, int mno, int num, String order_Date,
			int ostatus) {
		super();
		this.ono = ono;
		this.tno = tno;
		this.mno = mno;
		this.num = num;
		this.order_Date = order_Date;
		this.ostatus = ostatus;
	}

	@Override
	public String toString() {
		return "Order [ono=" + ono + ", tno=" + tno + ", mno=" + mno + ", num="
				+ num + ", order_Date=" + order_Date + ", ostatus=" + ostatus + "]";
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(String order_Date) {
		this.order_Date = order_Date;
	}

	public int getOstatus() {
		return ostatus;
	}

	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mno;
		result = prime * result + num;
		result = prime * result + ono;
		result = prime * result
				+ ((order_Date == null) ? 0 : order_Date.hashCode());
		result = prime * result + ostatus;
		result = prime * result + tno;
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
		Order other = (Order) obj;
		if (mno != other.mno)
			return false;
		if (num != other.num)
			return false;
		if (ono != other.ono)
			return false;
		if (order_Date == null) {
			if (other.order_Date != null)
				return false;
		} else if (!order_Date.equals(other.order_Date))
			return false;
		if (ostatus != other.ostatus)
			return false;
		if (tno != other.tno)
			return false;
		return true;
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
	

	

}
