package pktbcki.org.rzd.OrdersProject;

import java.util.ArrayList;
import java.util.List;

import org.voltdb.VoltTable;

import pktbcki.org.rzd.OrdersProject.Database.ConnectEntity;
import pktbcki.org.rzd.OrdersProject.Database.DbInterface;
import pktbcki.org.rzd.OrdersProject.Database.ConnectToDb;
import pktbcki.org.rzd.OrdersProject.Database.ConnectToDbFake;
import pktbcki.org.rzd.OrdersProject.Entity.Products;
import pktbcki.org.rzd.OrdersProject.Entity.Orders;
import pktbcki.org.rzd.OrdersProject.OrderSystem.RequestSystemMain;
import pktbcki.org.rzd.OrdersProject.OrderSystem.RequestSystemFake;
import pktbcki.org.rzd.OrdersProject.OrderSystem.RequestSystemInterface;

public class MainClass {

	public static void main(String[] args) {
		
		ConnectEntity userDb1 = new  ConnectEntity("192.168.122.129", 21212, "admin", "admin");	
		DbInterface conn1 = new ConnectToDb(); 
		
		//connect to data store
		conn1.connect(userDb1);

		//delete content from table 'products' 
		conn1.delete("delete from products");
		//insert content into table 'products'
		conn1.insert("insert into products values(1,50,10,'sausage','The best sausage in the world')");
		conn1.insert("insert into products values(2,10,100,'potato','Very good potato')");
		conn1.insert("insert into products values(3,30,50,'orange','so orange... mmm... orange')");
		//update content in table 'products'	(for test update query)
		conn1.update("update products set quantity=47 where id=3");
		//select content from table 'products'
		List<Products> list = new ArrayList<Products>();
		VoltTable results[] = conn1.select("select * from products");	
		Products prods[] = new Products[results[0].getRowCount()];
		for(int i=0; i<results[0].getRowCount(); i++)
		{
			prods[i]=new Products();
			prods[i].setId(results[0].fetchRow(i).getLong(0));
			prods[i].setPrice(results[0].fetchRow(i).getLong(1));
			prods[i].setQuantity(results[0].fetchRow(i).getLong(2));
			prods[i].setName(results[0].fetchRow(i).getString(3));
			prods[i].setOverview(results[0].fetchRow(i).getString(4));	
			list.add(prods[i]);
		}
		for(Products pr: list){
			System.out.print(pr.getId() + " ");
			System.out.print(pr.getPrice() + " ");
			System.out.print(pr.getQuantity() + " ");
			System.out.print(pr.getName() + " ");
			System.out.print(pr.getOverview() + " ");
			System.out.println("");
		}
		
		//we are selected data from data source and generate WEB-page for clients
		//generatePage();
		
		//Client add items in basket and push buy button => generated requests	
		//get client request
		
		Long idOrder=0L;
		
		List<Orders> listReq = new ArrayList<Orders>();
		RequestSystemInterface rs = new RequestSystemMain();
		listReq=rs.getRequest();
		conn1.delete("delete  from orders");
		for(Orders req: listReq){
			conn1.insert("insert into orders values (" 
						+idOrder + ","
						+ "'" + req.getDateOrder() +"'" + ","
						+req.getManagerId() + ","
						+req.getId() + ","
						+req.getPrice() + ","
						+req.getQuantity() + ","
						+req.getStatus() + ")"
						);	
			idOrder++;
		}
		System.out.println("Client Request:");
		for(Orders req: listReq){
			System.out.print(req.getId() + " ");
			System.out.print(req.getPrice() + " ");
			System.out.print(req.getQuantity() + " ");
			System.out.println();
		}
		
		//write client request to database and attach manager for purchase 
		//get managers for the request
		rs.getManagers(listReq);
		//update the table 'orders'. Set information about managers
		for(Orders req: listReq){
			conn1.insert("update orders set "
					+ "dateorder=" + "'" + req.getDateOrder() + "'"
					+ ","
					+ "managerid=" + req.getManagerId()
					+ ","
					+ "status=" + req.getStatus()
					);
		}
		
		//Select information from table 'orders'
		List<Orders> listOrders = new ArrayList<Orders>();
		VoltTable resultsOrders[] = conn1.select("select * from orders");	
		Orders ords[] = new Orders[resultsOrders[0].getRowCount()];
		for(int i=0; i<results[0].getRowCount(); i++)
		{
			ords[i]=new Orders();
			ords[i].setnOrder(resultsOrders[0].fetchRow(i).getLong(0));
			ords[i].setDateOrder(resultsOrders[0].fetchRow(i).getString(1));
			ords[i].setManagerId(resultsOrders[0].fetchRow(i).getLong(2));		
			ords[i].setId(resultsOrders[0].fetchRow(i).getLong(3));
			ords[i].setPrice(resultsOrders[0].fetchRow(i).getLong(4));
			ords[i].setQuantity(resultsOrders[0].fetchRow(i).getLong(5));
			ords[i].setStatus(resultsOrders[0].fetchRow(i).getLong(6));
			listOrders.add(ords[i]);
		}
		for(Orders or: listOrders){
			System.out.print(or.getId() + " ");
			System.out.print(or.getPrice() + " ");
			System.out.print(or.getQuantity() + " ");
			System.out.print(or.getnOrder() + " ");
			System.out.print(or.getDateOrder() + " ");
			System.out.print(or.getManagerId() + " ");
			System.out.print(or.getStatus() + " ");
			System.out.println("");
		}

		//disconnect from data store
		conn1.disconnect(userDb1);
	}
}
