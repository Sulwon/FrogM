package frogM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Login extends UI implements ActionListener, MouseListener, Runnable{

	int olderTab = 0;
	String command = "", text = "";
	newLabel talk;
	newPanel p1, p2, p3, frog, btn, loading;
	Frame f1,f2;
	newTextField tf1, tf2;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	FrogMgr mgr = new FrogMgr();
	Tab1 tab1 = new Tab1(); //일정 
	Tab2 tab2 = new Tab2(); //관리
	Tab3 tab3 = new Tab3(); //직원
	Tab4 tab4 = new Tab4(); //현황
	Tab5 tab5 = new Tab5(); //공지	
	newPanel [] tabs = new newPanel[10];
	
	public Login() {
		f1 = newFrame(d.width/2-190, d.height, 1300, 800, new Color(255, 255, 255,0));
		talk = new newLabel("", 160, 20, 250, 70, 20, Color.white, "Meriyo UI");
		frog = new newPanel("frog.png", 10,0, 118, 121);	
		btn = new newPanel("btn.png", 250, 410, 100, 47);	
		
		p1 = new newPanel("login2.png",0,100,380,700);
		p2 = new newPanel("loading.png",0,100,380,700);
		p3 = new newPanel("main.png",0,100,380,700);
		loading = new newPanel("loading.gif",40,350,300,171);
		tf1 = new newTextField(55, 395, 180, 30, 10, "Meiryo UI");
		tf2 = new newTextField(55, 440, 180, 30, 10, "Meiryo UI");	
		for(int i = 0; i < 10; i++) {
			if (i < 5) {		
				final int k = i;		
				tabs[i] = new newPanel("tab" + k + "_true.png",1229,20+(k*65),100,67);
				if (k == 0) tabs[i].setVisible(true);		
				else tabs[i].setVisible(false);						
			} else {
				final int k = i-5;
				tabs[i] = new newPanel("tab" + k + "_false.png",1229,20+(k*65),100,67);
				tabs[i].setVisible(true);
				if (k == 0) tabs[i].setVisible(false);		
				else tabs[i].setVisible(true);						
			}
			tabs[i].addMouseListener(this);
			p3.add(tabs[i]);
		}
		
		tab1.setBounds(0, 0, 1235, 610); //사이즈
		tab2.setBounds(0, 0, 1235, 610);
		tab3.setBounds(0, 0, 1235, 610);
		tab4.setBounds(0, 0, 1235, 610);
		tab5.setBounds(0, 0, 1235, 610);
		tab1.setVisible(true);
		p1.add(btn);
		p1.add(tf1);
		p1.add(tf2);
		p2.add(loading);
		p3.add(tab1);
		p3.add(tab2);
		p3.add(tab3);
		p3.add(tab4);
		p3.add(tab5);
		f1.add(frog);
		f1.add(talk);
		f1.add(p1);
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn.addMouseListener(this);
		init(f1);	
		command("breath:1");
	}
	
	public void checkLogin() {
		if(tf1.getText().length() == 0) {
			command("talking:아이디를 입력해야해!");
			tf1.requestFocus();
		} else if (tf2.getText().length() == 0) {
			command("talking:비밀번호를 입력해야해!");
			tf2.requestFocus();
		} else {
			if(mgr.loginChk(tf1.getText().trim(),tf2.getText().trim())) {
				command("talking:로그인에 성공했어!");
				command("loading:1");
			} else {
				command("talking:잘못된 정보야!");					
			}
		}		
	}	
	
	
	public void init(Frame frame) {
		
		int fx = frame.getX();
		delay(1);
		frame.setVisible(true);
		for (int i = 0; i < 50; i++) { 
			frame.setLocation(fx, frame.getY()-1);
			delay(15);
		}
		delay(300);
		for (int i = 0; i < 25; i++) {
			frame.setLocation(fx, frame.getY()+2);
			delay(10);
		}
		delay(100);
		for (int i = 0; i < 31; i++) {
			frame.setLocation(fx, frame.getY()-(i*2));
			delay(10);
		}
		frame.setSize(1300,frame.getHeight());
	}
	
	public static void delay(long delay) {
		try {
			Thread.sleep(delay);
		} catch (Exception e) {}
	}
	
	public void command(String cmd) {
		command = cmd.split(":")[0];
		text = cmd.split(":")[1];
		new Thread(this).start();
	}
	
	@Override
	public void run() {		
		
		switch (command) {
			case "breath":
				p3.setVisible(false);
				while(!p3.isVisible()) {
					for (int i = 0; i < 3; i++) {
						frog.setLocation(frog.getX(), frog.getY()+i);
						delay(150);
					}
					for (int i = 0; i < 3; i++) {
						frog.setLocation(frog.getX(), frog.getY()-i);
						delay(150);
					}
				}
			case "talking":
				String dummy = text;
				for (int i = 0 ; i <= dummy.length(); i ++) {
					talk.setText(dummy.substring(0, i));
					delay(15);
				}
				delay(2000);
				talk.setText("");
				break;
			case "loading":
				f1.add(p2);
				f1.remove(p1);
				delay(3000);
				p3.setVisible(true);
				f1.add(p3);
				f1.remove(p2);
				int fy = f1.getY();
				for(int i = 0; i < 46; i++) {
					f1.setLocation(f1.getX()-10,fy);
					p3.setSize(p3.getWidth()+20,p3.getHeight());
					delay(5);
				}
				break;
			case "opentab":
				if(Integer.parseInt(text) == olderTab) return;
				switch(olderTab) {
				case 0:
					tab1.setVisible(false);
					break;
				case 1:
					tab2.setVisible(false);
					break;
				case 2:
					tab3.setVisible(false);
					break;
				case 3:
					tab4.setVisible(false);
					break;
				case 4:
					tab5.setVisible(false);
					break;
				}
				switch(Integer.parseInt(text)) {
				case 0:
					tab1.setVisible(true);
					break;
				case 1:
					tab2.setVisible(true);
					break;
				case 2:
					tab3.setVisible(true);
					break;
				case 3:
					tab4.setVisible(true);
					break;
				case 4:
					tab5.setVisible(true);
					break;
				}		
				tabs[olderTab+5].setVisible(true);
				tabs[olderTab].setVisible(false);
				tabs[Integer.parseInt(text)].setVisible(true);
				tabs[Integer.parseInt(text)+5].setVisible(false);
				p3.repaint();
				p3.revalidate();
				olderTab = Integer.parseInt(text);
				command("talking:[" + text + "]번 탭을 열었어!");
				
		}
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == tf1 || obj == tf2) checkLogin();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			checkLogin();
		} else {
			for(int i = 0; i < 10; i++) {
				if (obj == tabs[i]) {
					command("opentab:" + (i > 4 ? i - 5 : i));
					return;
				}
			}			
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public static void main(String[] args) {
		Login login = new Login();
	}
}