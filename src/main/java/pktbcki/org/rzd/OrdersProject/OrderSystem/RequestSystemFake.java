package pktbcki.org.rzd.OrdersProject.OrderSystem;

import java.util.ArrayList;
import java.util.List;

import pktbcki.org.rzd.OrdersProject.Entity.Orders;

public class RequestSystemFake implements RequestSystemInterface{

	@Override
	public List<Orders> getRequest() {
		List<Orders> list = new ArrayList<Orders>();
		Orders req = new Orders(1L, 50L, 1L);
		list.add(req);
		return list;
	}

	@Override
	public List<Orders> getManagers(List<Orders> list) {
		// TODO Auto-generated method stub
		return list;
	}

}
