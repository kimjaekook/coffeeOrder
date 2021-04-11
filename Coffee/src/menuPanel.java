import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class menuPanel extends JPanel {
	
	String toppingName[] = {"�Ƹ޸�ī��", "ī��� �����ƶ�", "ī���", "�ٴҶ��"};
	public JButton toppingCB[] = new JButton[toppingName.length];
	public menuPanel() {
		this.setLayout(new GridLayout(0,1));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < toppingName.length; i++) {
			toppingCB[i] = new JButton(toppingName[i]);
			this.add(toppingCB[i]);
			bg.add(toppingCB[i]);
		}
		this.setBorder(BorderFactory.createTitledBorder("�����  �����ϼ���?"));
	}
	
	public int calcToppingSelect() {
		
		int subTotal = 0;
		int costOfTopping[] = {50, 100, 150, 200};
		for(int i = 0; i < costOfTopping.length; i++) {
			if(toppingCB[i].isSelected())
				subTotal += costOfTopping[i];
		}
		return subTotal;
	}
}
