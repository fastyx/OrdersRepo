package pktbcki.org.rzd.OrdersProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.voltdb.VoltTable;

import pktbcki.org.rzd.OrdersProject.Database.CRUDToDb;
import pktbcki.org.rzd.OrdersProject.Database.ConnectEntity;
import pktbcki.org.rzd.OrdersProject.Database.ConnectToDb;
import pktbcki.org.rzd.OrdersProject.Entity.Orders;

public class CRUDToDbTest {

	static CRUDToDb crud;
	static ConnectEntity userDb1;
	static VoltTable results[];;
	
	@BeforeClass
	public static void beforeClass(){
		crud = new ConnectToDb();
		userDb1 = new  ConnectEntity("192.168.122.129", 21212, "admin", "admin");	
		results=null;
	}
	
	@AfterClass 
	public static void afterClass(){
		crud = null;
		userDb1=null;
		results=null;
	}
	
	//check orders table
	@Test
	public void test1() {
		crud.connect(userDb1);
		
		results=crud.select("select * from orders");
		assertNotNull("table not created!",results);	
	}
	
	//check products table
	@Test
	public void test2() {
		crud.connect(userDb1);
		
		results=crud.select("select * from products");
		assertNotNull("table not created!",results);	
	}

}
