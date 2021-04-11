import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ItemListener extends JPanel {
	
	String typeName[] = {"Hot", "Ice"};
	public JRadioButton typeRB[] = new JRadioButton[typeName.length];
	public ItemListener() {
		this.setLayout(new GridLayout(0,2));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < typeName.length; i++) {
			typeRB[i] = new JRadioButton(typeName[i]);
			this.add(typeRB[i]);
			bg.add(typeRB[i]);
		}
		typeRB[0].setSelected(true);
		this.setBorder(BorderFactory.createTitledBorder("어떤 타입이신가요?"));
	}
	
	public int calctypeSelect() {

		int costType[] = {1500, 1000};
		for(int i = 0; i < costType.length; i++) {
			if(typeRB[i].isSelected())
				return costType[i];
		}
		return 0;
	}
}
