package pktbcki.org.rzd.OrdersProject.OrderSystem;

import java.util.List;

import pktbcki.org.rzd.OrdersProject.Entity.Orders;

public interface RequestSystemInterface {

	public List<Orders> getRequest();
	public List<Orders> getManagers(List<Orders> list1);
}
