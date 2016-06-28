package pktbcki.org.rzd.OrdersProject;

import java.sql.ResultSet;
import java.sql.Statement;

import org.voltdb.VoltTable;
import org.voltdb.VoltType;

import pktbcki.org.rzd.OrdersProject.Database.ConnectEntity;
import pktbcki.org.rzd.OrdersProject.Database.ConnectInterface;
import pktbcki.org.rzd.OrdersProject.Database.ConnectToVoltDb;
import pktbcki.org.rzd.OrdersProject.Entity.Products;

public class MainClass {

	public static void main(String[] args) {
		ConnectEntity userDb1 = new  ConnectEntity("192.168.122.129", 21212, "admin", "admin");
		
		ConnectInterface conn1 = new ConnectToVoltDb(); 
		
		conn1.connect(userDb1);
		
		Products prod = new Products();
		
		
		//delete content from table 'products'
		conn1.delete("delete from products");
		//insert content into table 'products'
		conn1.insert("insert into products values(1,50,10,'sausage','The best sausage in the world')");
		conn1.insert("insert into products values(2,10,100,'potato','Very good potato')");
		conn1.insert("insert into products values(3,30,50,'orange','so orange... mmm... orange')");
		//update content in table 'products'
		conn1.update("update products set quantity=47 where id=3");
		//select content from table 'products'
		conn1.select("select * from products",prod);

		System.out.println(prod.results[0].getColumnName(0));
		System.out.println(prod.results[0].getColumnName(1));
		System.out.println(prod.results[0].getColumnName(2));
		
		System.out.println(prod.results[0].advanceRow());
		System.out.println(prod.results[0].toJSONString());
		
		System.out.println(prod.results[0].toFormattedString());
		
		System.out.println(prod.results[0].fetchRow(2).getLong(1));
		
		
		
		//conn1.select("select * from products");
	}
}
