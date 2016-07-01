package pktbcki.org.rzd.OrdersProject.Database;

import java.util.List;

import org.voltdb.VoltTable;

public class ConnectToDbFake implements DbInterface {

	public void connect(ConnectEntity userDb) {
		System.out.println("Connect to DbFake");
	}

	public void disconnect(ConnectEntity userDb) {	
		System.out.println("Disconnect from DbFake");
	}

	public void insert(String query) {
		// TODO Auto-generated method stub
		
	}

	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String query) {
		// TODO Auto-generated method stub
		
	}

	public VoltTable[] select(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
