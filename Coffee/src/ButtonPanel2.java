import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel2 extends JPanel {

	
	public JButton btnDelRow = new JButton("�����");
	public JButton btnReset = new JButton("����ʱ�ȭ");
	public JButton btnReload = new JButton("�ҷ�����");
	
	public ButtonPanel2() {
		this.setLayout(new GridLayout(0,4));
		
		this.add(btnDelRow);
		this.add(btnReset);
		this.add(btnReload);
	}
}
