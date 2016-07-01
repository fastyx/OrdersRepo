package pktbcki.org.rzd.OrdersProject.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.NoConnectionsException;
import org.voltdb.client.ProcCallException;

import pktbcki.org.rzd.OrdersProject.Entity.Products;

public abstract class CRUDToDb implements DbInterface{
	
	protected Client client;
	protected ClientConfig config; 
	
	abstract public void connect(ConnectEntity userDb);
	
	abstract public void disconnect(ConnectEntity userDb);
	
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
		} catch (NoConnectionsException e ) {
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
	
	public VoltTable[] select(String query){
		try {
			return client.callProcedure("@AdHoc", query).getResults();	
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
		
		return null;		
	}
	
	/*public List<?> select(String query){
		List<Products> list = new ArrayList<Products>();		
				
		try {
			VoltTable results[]=client.callProcedure("@AdHoc", query).getResults();
			
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
		
		return list;
	}*/
	
}
