import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {

	String header[] = {"온도", "메뉴", "사이즈","가격"};
	public DefaultTableModel model = new DefaultTableModel(header, 0);
	public JTable table = new JTable(model);

	public OrderUI fdbGUI;
	public TablePanel(OrderUI orderUI) {
		this.fdbGUI = orderUI;
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
		
//		String st[] = {"dfd","dfsf","fdf"};
//		model.addRow(st);
//		
//		//Vector<String> rowData = new Vector<String>();
//		Vector data = new Vector();
//		
//		data.add("홍 ");
//		data.add("45543534");
//		data.add("34");
//		//data.addElement(rowData);
//		model.addRow(data);
	}
}
