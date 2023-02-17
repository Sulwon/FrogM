//현황

package frogM;
import java.awt.Color;
import javax.swing.JPanel;

public class Tab4 extends JPanel {
	public Tab4() {				
		newLabel example = new newLabel("현황", 0, 0, 200, 200, 30, Color.black , "폰트없음");
		add(example);
		

		setLayout(null);		
		setBackground(new Color(255,255,255,0));
		setOpaque(false);
		revalidate();
		repaint();
		setVisible(false); //이거 남겨놔주세요!
	}	
}