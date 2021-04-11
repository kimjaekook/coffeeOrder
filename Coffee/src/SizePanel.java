import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SizePanel extends JPanel {
	
	String sizeName[] = {"Small", "Medium", "Large"};
	public JRadioButton sizeRB[] = new JRadioButton[sizeName.length];
	public SizePanel() {
		this.setLayout(new GridLayout(0,3));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < sizeName.length; i++) {
			sizeRB[i] = new JRadioButton(sizeName[i]);
			this.add(sizeRB[i]);
			bg.add(sizeRB[i]);
		}
		sizeRB[0].setSelected(true);
		this.setBorder(BorderFactory.createTitledBorder("크기는 어떻게 드릴까요?"));
	}
	
	public int calcSizeSelect() {

		int costType[] = {0, 500, 1000};
		for(int i = 0; i < costType.length; i++) {
			if(sizeRB[i].isSelected())
				return costType[i];
		}
		return 0;
	}
}
