import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class MyMouseListener implements MouseListener {

	public OrderUI fdb;
	public MyMouseListener(OrderUI orderUI) {
		// TODO Auto-generated constructor stub
		this.fdb = orderUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = ((TablePanel)fdb.basePanel[2]).table.getSelectedRow();
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 0));
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 1));
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 2));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = ((TablePanel)fdb.basePanel[2]).table.getSelectedRow();
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 0));
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 1));
		System.out.println(((TablePanel)fdb.basePanel[2]).model.getValueAt(index, 2));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
