package pktbcki.org.rzd.OrdersProject.Database;

import java.io.IOException;

import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.NoConnectionsException;
import org.voltdb.client.ProcCallException;

public abstract class CRUDToVoltDB implements ConnectInterface{
	
	protected Client client;
	protected ClientConfig config; 
	
	abstract public  void connect(ConnectEntity userDb);
	
	abstract public void disconnect();
	
	public void insert(String query) {
		try {
			client.callProcedure("@AdHoc", query);
		} catch (NoConnectionsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String query) {
		try {
			client.callProcedure("@AdHoc", query);
		} catch (NoConnectionsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String query) {
		try {
			client.callProcedure("@AdHoc", query);
		} catch (NoConnectionsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select(String query){
		try {
			client.callProcedure("@AdHoc", query);
		} catch (NoConnectionsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcCallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
