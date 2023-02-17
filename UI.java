package frogM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JFrame{

	public Frame newFrame(int x, int  y, int w, int h, Color c) {
		Frame frame;
		frame = new Frame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(w,h);
		frame.setLocation(x,y);		
		frame.setBackground(c);

		return frame;
	}

 }

class newLabel extends JLabel {
	
	public newLabel(String t, int x, int y, int w, int h, int s, Color c, String f) {
		setText(t);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(x, y, w, h);
		setFont(new Font(f, Font.PLAIN, s));
		setForeground(c);	
	}
}

class newPanel extends JPanel {
	Image image;
	int x, y, w, h;
	public newPanel(String img, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;		
		image = Toolkit.getDefaultToolkit().createImage("./frogM/image/" + img);
		setLayout(null);
		setOpaque(false);
		setBounds(x, y, w, h);
	}
	public void paintComponent(Graphics g) {  
	    super.paintComponent(g);  
	    if (image != null) {  
	      g.drawImage(image, 0, 0, this);  
	    }  
	  } 
}

class newTextField extends JTextField {
	
    private Shape shape;
    public newTextField(int x, int y, int w, int h, int s, String f) {
        setBounds(x, y, w, h);
        setFont(new Font(f, Font.PLAIN, s));
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}
