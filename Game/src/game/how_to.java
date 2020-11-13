package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class how_to extends JPanel{
	private ImageIcon fielddhowtoplay = new ImageIcon(this.getClass().getResource("how1.png"));
	private ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
	public JButton BBack  = new JButton(back);
	
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		   g.drawImage(fielddhowtoplay.getImage(),0,0,1000,800,this);	
	  }
	how_to(){
		setLayout(null);
		BBack.setBounds(750, 650,150,65);
		add(BBack);
	}

}
