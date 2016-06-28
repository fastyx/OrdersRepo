package pktbcki.org.rzd.OrdersProject.Database;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.NoConnectionsException;
import org.voltdb.client.ProcCallException;
import org.voltdb.client.ProcedureCallback;

import pktbcki.org.rzd.OrdersProject.Entity.Products;

public class ConnectToVoltDb extends CRUDToVoltDB {

	
	//ConnectEntity userDb = new ConnectEntity("192.168.122.129", 21212, "admin", "admin");

	public void connect(ConnectEntity userDb) {
		
		config = new ClientConfig(userDb.getLogin(),userDb.getPassword());
		client=ClientFactory.createClient(config);
		try {
			client.createConnection(userDb.getIp(),userDb.getPort());
			
			System.out.println("Connection successes!!!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		// TODO Auto-generated method stub
		
	}
}
