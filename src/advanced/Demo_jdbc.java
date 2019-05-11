package advanced;

import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Demo_jdbc {
	public static void main(String[]args) throws ClassNotFoundException,SQLException, IOException{
		Properties properties=new Properties();
		properties.load(new FileInputStream("D:/swetha/advancedjava/Db.properties"));
		Class.forName(properties.getProperty("driver"));
		Connection con=DriverManager.getConnection(properties.getProperty("url"),properties);
		System.out.println(con);
        System.out.println(properties.getProperty("driver"));
        System.out.println(properties.getProperty("url")+properties);
         PreparedStatement st=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
       Scanner s=new Scanner(System.in);
         while(true)
        {
        	System.out.println("enter id");
        	System.out.println("enter name");
        	System.out.println("enter maths marks");
        	System.out.println("enter physics marks");
        	System.out.println("enter chemistry marks");
        	System.out.println("enter total");
        	int id=s.nextInt();
        	String name=s.next();
         	int  maths=s.nextInt();
         	int physics=s.nextInt();
         	int chemistry=s.nextInt();
         	int  total=s.nextInt();
         	st.setInt(1, id);
         	st.setString(2, name);
         	st.setInt(3, maths);
         	st.setInt(4, physics);
         	st.setInt(5, chemistry);
         	st.setInt(6, total);
         	st.executeUpdate();
         	System.out.println("enter 1 to continue");
         	int i=s.nextInt();
         	if(i==1)
         	{
       
         	}
         	else{
         		System.exit(0);
         	}
        	
        	
        	
        	
        }
        
        
	}
}
         