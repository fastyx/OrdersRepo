package pktbcki.org.rzd.OrdersProject.Database;

import java.util.List;

import org.voltdb.VoltTable;

import pktbcki.org.rzd.OrdersProject.Entity.Products;

public interface ConnectInterface {
	
	void connect(ConnectEntity userDb);
	
	void disconnect();
	
	void insert(String query);
	void update(String query);
	void delete(String query);
	void select(String query,Products prod);
}
