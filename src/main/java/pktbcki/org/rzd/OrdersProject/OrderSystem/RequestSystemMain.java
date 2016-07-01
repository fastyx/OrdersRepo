package pktbcki.org.rzd.OrdersProject.OrderSystem;

import java.util.ArrayList;
import java.util.List;

import pktbcki.org.rzd.OrdersProject.Entity.Orders;

public class RequestSystemMain implements RequestSystemInterface {
	
	@Override
	public List<Orders> getRequest(){
		List<Orders> list = new ArrayList<Orders>();
		Orders req[] = new Orders[3];
		req[0]= new Orders(1L,50L,1L);
		list.add(req[0]);
		req[1]= new Orders(3L,90L,3L);
		list.add(req[1]);
		req[2]= new Orders(2L,50L,5L);
		list.add(req[2]);
		return list;
	}

	@Override
	public List<Orders> getManagers(List<Orders> list) {
		for(Orders req: list){
			req.setManagerId(101L);
			req.setnOrder(19234L);
			req.setStatus(1L);
			req.setDateOrder("2016-07-01-08.00.00.000000");
		}
		return list;
	}
}
