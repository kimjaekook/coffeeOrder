import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class menuPanel extends JPanel {
	
	String toppingName[] = {"아메리카노", "카라멜 마끼아또", "카페라떼", "바닐라라떼"};
	public JButton toppingCB[] = new JButton[toppingName.length];
	public menuPanel() {
		this.setLayout(new GridLayout(0,1));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < toppingName.length; i++) {
			toppingCB[i] = new JButton(toppingName[i]);
			this.add(toppingCB[i]);
			bg.add(toppingCB[i]);
		}
		this.setBorder(BorderFactory.createTitledBorder("어떤것을  좋아하세요?"));
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
