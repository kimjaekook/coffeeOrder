import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MyDBActionListener implements ActionListener {

	public OrderUI fdb;
	public Vector orRow;

	public MyDBActionListener(OrderUI orderUI) {
		// TODO Auto-generated constructor stub
		this.fdb = orderUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == ((ButtonPanel2)fdb.basePanel[1]).btnDelRow) {
			if (((TablePanel)fdb.basePanel[2]).table.isFocusable()) {
				int index = ((TablePanel)fdb.basePanel[2]).table.getSelectedRow();
				System.out.println(""+index);
				((TablePanel)fdb.basePanel[2]).model.removeRow(index);
			}
		}
		
		if (e.getSource() == ((ButtonPanel2)fdb.basePanel[1]).btnReset) {
			int count = ((TablePanel)fdb.basePanel[2]).table.getRowCount();
			System.out.println(count);
			for (int i=0; i< count; i++) {
				((TablePanel)fdb.basePanel[2]).model.removeRow(0);
			}
			((TablePanel)fdb.basePanel[2]).table.repaint();
		}
		
		if (e.getSource() == ((ButtonPanel2)fdb.basePanel[1]).btnReload) {
			
			try {
				Statement stmt = fdb.con.createStatement();
				ResultSet reload_rs = stmt.executeQuery("select * from coffee");
				while (reload_rs.next()) {							
					String type = reload_rs.getString("type");
					String menu = reload_rs.getString("menu");
					String size = reload_rs.getString("size");
					int price = reload_rs.getInt("price");
					fdb.orderRow = new Vector<String>();
					fdb.orderRow.addElement(type);
					fdb.orderRow.addElement(menu);
					fdb.orderRow.addElement(size);
					fdb.orderRow.addElement(Integer.toString(price));
					
					((TablePanel)fdb.basePanel[2]).model.addRow(fdb.orderRow);
					
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("ERR Reload");
				e1.printStackTrace();
			}
			
		
		}
	}

}
