import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	public JLabel msgLB = new JLabel();
	public WelcomePanel() {
		msgLB.setText("�ѽŴ� ����������Դϴ�.\n");
		this.add(msgLB);
	}
}
