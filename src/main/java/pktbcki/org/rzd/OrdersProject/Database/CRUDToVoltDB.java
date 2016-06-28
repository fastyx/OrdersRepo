package pktbcki.org.rzd.OrdersProject.Database;

import java.io.IOException;

import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.NoConnectionsException;
import org.voltdb.client.ProcCallException;

import pktbcki.org.rzd.OrdersProject.Entity.Products;

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

	public void select(String query, Products prod){
		
		
		try {
			prod.setResults(client.callProcedure("@AdHoc", query).getResults());
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
		
	/*	boolean alldone = false;
		while ( ! alldone ) {
			try {
				tab = client.callProcedure("@AdHoc", query).getResults();
			} catch (NoConnectionsException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ProcCallException e) {
				e.printStackTrace();
			}
			if (tab[0].getRowCount() < 1) {
				System.out.println("The table is empty!");
			    alldone = true; 
			} 
			else {
				alldone = true; 
				System.out.println(tab[0]);
			}
		}	*/	
		
	}
}
