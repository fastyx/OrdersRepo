package pktbcki.org.rzd.OrdersProject.Database;

import java.util.List;

import org.voltdb.VoltTable;

import pktbcki.org.rzd.OrdersProject.Entity.Products;

public interface DbInterface {
	
	void connect(ConnectEntity userDb);	
	
	void disconnect(ConnectEntity userDb);	
	
	void insert(String query);
	void update(String query);
	void delete(String query);
	//List<?> select (String query);	//products and orders
	VoltTable[] select (String query);
}
