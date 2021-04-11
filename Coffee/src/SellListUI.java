import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SellListUI extends JFrame{
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public JPanel basePanel[] = new JPanel[2];
	public JPanel selectPanel[]= new JPanel[5];
	public JTextArea resultTA = new JTextArea(10,20);
	public JTextArea resultTF = new JTextArea(0,10);
	public JButton orderBT = new JButton("주문");
	
	public JButton btnAmc = new JButton("아메리카노");
	public JButton btnCmt = new JButton("카라멜마끼아또");
	public JButton btnCfr = new JButton("카페라떼");
	public JButton btnBan = new JButton("바닐라라떼");

	public SellListUI() throws SQLException {
		con = makeConnection();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("요거프레소");
		
		basePanel[0] = new JPanel(new BorderLayout(3,1));
		basePanel[1] = new JPanel(new BorderLayout(0,3));
		
		selectPanel[0] = new WelcomePanel();
		selectPanel[1] = new ButtonPanel();
		selectPanel[2] = new ItemListener();
		selectPanel[3] = new SizePanel();
	
		selectPanel[4] = new JPanel();
			
		
		
		basePanel[0].add(selectPanel[0], BorderLayout.NORTH);
		basePanel[0].add(new JScrollPane(resultTA), BorderLayout.CENTER);
		basePanel[0].add(new JScrollPane(resultTF), BorderLayout.SOUTH);
		basePanel[1].add(selectPanel[2], BorderLayout.NORTH);
		basePanel[1].add(selectPanel[1], BorderLayout.CENTER);
		basePanel[1].add(selectPanel[3], BorderLayout.EAST);
		basePanel[1].add(orderBT, BorderLayout.SOUTH);
		
		basePanel[0].add(selectPanel[3], BorderLayout.SOUTH);
		
	
		MyButtonListener mbl = new MyButtonListener(this);
		
		//MyDBActionListener MDBAL = new MyDBActionListener(this);
		orderBT.addActionListener(mbl);
		
		
		for(int i = 0; i < ((ButtonPanel) selectPanel[1]).MenuRB.length; i++) {
			((ButtonPanel) selectPanel[1]).MenuRB[i].addActionListener(mbl);
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from coffee");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setLayout(new GridLayout(0,1));
		this.add(basePanel[0]);
		this.add(basePanel[1]);
		
		this.setSize(600,700);
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
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		new SellListUI();
	}

}