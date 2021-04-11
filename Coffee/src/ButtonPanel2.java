import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel2 extends JPanel {

	
	public JButton btnDelRow = new JButton("행삭제");
	public JButton btnReset = new JButton("출력초기화");
	public JButton btnReload = new JButton("불러오기");
	
	public ButtonPanel2() {
		this.setLayout(new GridLayout(0,4));
		
		this.add(btnDelRow);
		this.add(btnReset);
		this.add(btnReload);
	}
}
