package advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties properties=new Properties();
		properties.load(new FileInputStream("D:/swetha/advancedjava/Db.properties"));
		Class.forName(properties.getProperty("driver"));
		Connection con=DriverManager.getConnection(properties.getProperty("url"),properties);
		System.out.println(con);
        System.out.println(properties.getProperty("driver"));
        System.out.println(properties.getProperty("url")+properties);
        PreparedStatement pst=con.prepareStatement("select * from student where id=?");
        Scanner s=new Scanner(System.in);
        while(true)
        {
        	System.out.println("enter id index");
        	int id=s.nextInt();
        	pst.setInt(1, id);
        	ResultSet rs=pst.executeQuery();

        	while(rs.next())
        	{
        		System.out.println(rs.getString(2));
        		System.out.println(rs.getInt(3));
        		System.out.println(rs.getInt(4));
        		System.out.println(rs.getInt(5));
        		System.out.println(rs.getInt(6));
        	
        	}
        	System.out.println("enetr 1 to cnt");
        	int i=s.nextInt();
        	if(i==1){ }
        	else{
        	break;
        }

	}

	}
}
