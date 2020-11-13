package game;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gameover extends JPanel{
	
	private ImageIcon feildover = new ImageIcon("gameover.png");
	private ImageIcon exitover = new ImageIcon("exit.jpg");
	public JButton BExitover  = new JButton(exitover);
	
	Gameover(){
		
		this.setLayout(null);
		BExitover.setBounds(500, 650, 150,90);
		add(BExitover);
		
		
	}
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(feildover.getImage(),0,0,1000,800,this);
		  
		  
	      
	  }
}
