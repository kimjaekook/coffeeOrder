import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JPanel {
	String MenuName[] = {"�Ƹ޸�ī��", "ī��Ḷ���ƶ�", "ī���","�ٴҶ��"};
	public JButton MenuRB[] = new JButton[MenuName.length];
	public ButtonPanel() {
		this.setLayout(new GridLayout(0,2));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < MenuName.length; i++) {
			MenuRB[i] = new JButton(MenuName[i]);
			this.add(MenuRB[i]);
			bg.add(MenuRB[i]);
		}
		MenuRB[0].setSelected(true);
		this.setBorder(BorderFactory.createTitledBorder("�� ��ðھ��?"));
	}
	
	public int calcTypeSelect() {

		int costType[] = {3000, 4000, 4500,5000};
		for(int i = 0; i < costType.length; i++) {
			if(MenuRB[i].isSelected())
				return costType[i];
		}
		return 0;
	}
	
	public void resetType() {
		MenuRB[0].setSelected(true);
	}
}
	
