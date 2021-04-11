import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	public JLabel msgLB = new JLabel();
	public WelcomePanel() {
		msgLB.setText("한신대 요거프레소입니다.\n");
		this.add(msgLB);
	}
}
