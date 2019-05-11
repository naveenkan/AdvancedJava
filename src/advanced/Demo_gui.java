package advanced;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

class Result implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6;
	TextField t1,t2,t3,t4,t5,t6;
	Button b1;
	Frame f;
	void create()
	{
	f=new Frame();
	l1=new Label("hallticketno:");
	l2=new Label("name:");
	l3=new Label("maths:");
	l4=new Label("physics:");
	l5=new Label("chemistry:");
	l6=new Label("total:");
	t1=new TextField(20);
	t2=new TextField(20);
	t3=new TextField(20);
	t4=new TextField(20);
	t5=new TextField(20);
	t6=new TextField(20);
	b1=new Button("submit");
	f.add(l1);
	f.add(t1);
	f.add(b1);
	b1.addActionListener((ActionListener) this);
	f.add(l2);
	f.add(t2);
	f.add(l3);
	f.add(t3);
	f.add(l4);
	f.add(t4);
	f.add(l5);
	f.add(t5);
	f.add(l6);
	f.add(t6);
	f.setLayout(new FlowLayout());
	f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		try{
			Properties properties=new Properties();
			properties.load(new FileInputStream("D:/swetha/advancedjava/Db.properties"));
			Class.forName(properties.getProperty("driver"));
			Connection con=DriverManager.getConnection(properties.getProperty("url"),properties);
			System.out.println(con);
	        System.out.println(properties.getProperty("driver"));
	        System.out.println(properties.getProperty("url")+properties);
	        PreparedStatement st=con.prepareStatement("select * from student where id=?");
	        int htno=Integer.parseInt(t1.getText());
	        st.setInt(1, htno);
	        ResultSet rs= st.executeQuery();
	        while(rs.next())
	        {
	        	t2.setText(rs.getString(2));
	        	t3.setText(rs.getInt(3)+"");
	        	t4.setText(rs.getInt(4)+"");
	        	t5.setText(rs.getInt(5)+"");
	        	t6.setText(rs.getInt(6)+"");
	        }
		}
	        catch(Exception e1)
	        {
	        	System.out.println(e1);
	        }
		
	}

		
	}

	
public class Demo_gui {
	public static void main(String[] args) {
		Result rs=new Result();
		rs.create();
		
	}
}


