//����

package frogM;
import java.awt.Color;
import javax.swing.JPanel;

public class Tab3 extends JPanel {
	public Tab3() {				
		newLabel example = new newLabel("����", 0, 0, 200, 200, 30, Color.black , "��Ʈ����");
		add(example);
		

		setLayout(null);		
		setBackground(new Color(255,255,255,0));
		setOpaque(false);
		revalidate();
		repaint();
		setVisible(false); //�̰� ���ܳ��ּ���!
	}	
}
