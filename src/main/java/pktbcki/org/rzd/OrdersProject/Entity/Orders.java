package pktbcki.org.rzd.OrdersProject.Entity;

import java.util.Date;

public class Orders {	
	private Long id;
	private Long price;
	private Long quantity;
	
	private Long nOrder;
	private String dateOrder;
	private Long managerId;
	private Long status;
	
	public Orders()
	{
	}
	
	public Orders(Long id, Long price, Long quantity){
		this.id=id;
		this.price=price;
		this.quantity=quantity;
		this.nOrder=0L;
		this.dateOrder="0000-00-00-00.00.00.000000";
		this.managerId=0L;
		this.status=0L;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getnOrder() {
		return nOrder;
	}

	public void setnOrder(Long nOrder) {
		this.nOrder = nOrder;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String string) {
		this.dateOrder = string;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
	
}
