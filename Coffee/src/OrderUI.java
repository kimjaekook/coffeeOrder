import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderUI extends JFrame {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Vector<String> orderRow = new Vector<String>();
	public JPanel basePanel[] = new JPanel[3];
	
	public OrderUI() {
		con = makeConnection();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("주문 DB GUI");
		this.setSize(400, 500);
		
		basePanel[1] = new ButtonPanel2();
		basePanel[2] = new TablePanel(this);
		
		MyDBActionListener MDBAL = new MyDBActionListener(this);
		MyMouseListener mml = new MyMouseListener(this);
	
		((ButtonPanel2)basePanel[1]).btnDelRow.addActionListener(MDBAL);
		((ButtonPanel2)basePanel[1]).btnReset.addActionListener(MDBAL);
		((ButtonPanel2)basePanel[1]).btnReload.addActionListener(MDBAL);
		
		((TablePanel)basePanel[2]).table.addMouseListener(mml);
		
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from contact");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		this.add(basePanel[1], BorderLayout.CENTER);
		this.add(basePanel[2], BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.pack();
	}
	
	public Connection makeConnection() {
		// TODO Auto-generated method stub
		// DB명 : friends
		// Table명 : contact
		// Field : (1) name varchar(10)
		// (2) phone varchar(15)
		// (3) age int
		// primary key(phone)
		
		
		Connection con = null;
		String url ="jdbc:mysql://localhost:3307/friends?characterEncoding=UTF-8&serverTimezone=UTC";
		String user ="root";
		String password ="8v970mjv";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC 적재 성공...");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC 적재 오류...");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결 실패...");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new OrderUI();
		
	}

}
