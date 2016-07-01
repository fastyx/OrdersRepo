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

public class ConnectToDb extends CRUDToDb {

	public void connect(ConnectEntity userDb) {
		
		config = new ClientConfig(userDb.getLogin(),userDb.getPassword());
		client=ClientFactory.createClient(config);
		try {
			client.createConnection(userDb.getIp(),userDb.getPort());
			
			System.out.println("Connection successes!!!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void disconnect(ConnectEntity userDb) {
		try {
			client.close();
			
			System.out.println("Disconnection successes!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
