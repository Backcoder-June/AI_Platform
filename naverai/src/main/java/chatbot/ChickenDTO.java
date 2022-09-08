package chatbot;

public class ChickenDTO {
	private String kind; 
	private String size; 
	private String telnum;
	private int price;
	private String ordertime; 
	
	
	
	
	
	
	public ChickenDTO(String kind, String size, String telnum, int price) {
		super();
		this.kind = kind;
		this.size = size;
		this.telnum = telnum;
		this.price = price;
	}


	public String getOrdertime() {
		return ordertime;
	}


	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}


	public ChickenDTO() {} 
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	
	
	

}
