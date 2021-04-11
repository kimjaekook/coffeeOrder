import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyButtonListener implements ActionListener {
	Connection con = null;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	String temp = " ";
	String temp2 =" ";
	String temp3 = " ";
	int costOfMenu[] = {3000,4000,4500,5000};
	int cost=0,price=0;
	public SellListUI ui;
	
	public MyButtonListener(SellListUI sellListUI) throws SQLException{
		// TODO Auto-generated constructor stub

		this.ui = sellListUI;
		con = ui.makeConnection();
		}
	public int totalSum() {
		
		ButtonPanel tp = ((ButtonPanel) ui.selectPanel[1]);
		SizePanel sp = ((SizePanel) ui.selectPanel[3]);
		ItemListener top = ((ItemListener) ui.selectPanel[2]);
		
		return tp.calcTypeSelect() + top.calctypeSelect() + sp.calcSizeSelect();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		ButtonPanel tp = ((ButtonPanel) ui.selectPanel[1]);
		SizePanel sp = ((SizePanel) ui.selectPanel[3]);
		ItemListener top = ((ItemListener) ui.selectPanel[2]);
		for(int i = 0; i < tp.MenuRB.length; i++) {
		if(e.getSource() == tp.MenuRB[i])
		{
			
			if(sp.sizeRB[0].isSelected()) { /*temp = " " ;*/ temp = sp.sizeName[0];}
			if(sp.sizeRB[1].isSelected()) { /*temp = " " ;*/ temp = sp.sizeName[1];}
			if(sp.sizeRB[2].isSelected()) { /*temp = " " ;*/ temp = sp.sizeName[2];}
			
			if(e.getSource() == tp.MenuRB[0]) { /*temp = " " ;*/ temp2 = tp.MenuName[0];}
			if(e.getSource() == tp.MenuRB[1]) { /*temp = " " ;*/ temp2 = tp.MenuName[1];}
			if(e.getSource() == tp.MenuRB[2]) { /*temp = " " ;*/ temp2 = tp.MenuName[2];}	
			if(e.getSource() == tp.MenuRB[3]) { /*temp = " " ;*/ temp2 = tp.MenuName[3];}	
			
			if(top.typeRB[0].isSelected()) { /*temp = " " ;*/ temp3 = top.typeName[0];}
			if(top.typeRB[1].isSelected()) { /*temp = " " ;*/ temp3 = top.typeName[1];}
			
			
		}
		}
		ui.resultTA.append(temp3 + " " + temp2 + " " +temp + " "+totalSum()+" 원입니다.\n");
		if(e.getSource() == ui.orderBT) {
			
			try {
				insertIntoDB2(temp3,temp2,temp,totalSum());
				ui.resultTA.append("주문들어갔습니다.\n");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		
		
	}
	private void insertIntoDB2(String type, String menu, String size, int price) throws SQLException {
		// TODO Auto-generated method stub
		pstmt = con.prepareStatement("insert into coffee (type, menu, size, price) values(?,?,?,?);");
		
		pstmt.setString(1, type);
		pstmt.setString(2, menu);
		pstmt.setString(3, size);
		pstmt.setInt(4, price);
		
		pstmt.executeUpdate();
	}

}
