package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homesgames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("homeBackground.jpg"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.jpg"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
        private ImageIcon how = new ImageIcon(this.getClass().getResource("how_to_play.png"));
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
        public JButton BHow  = new JButton(how);
	homesgames(){
            setLayout(null);
            BExit1.setBounds(750, 650,150,65);
            add(BExit1);
            BStart.setBounds(250,650,175,60);
            add(BStart);
            BHow.setBounds(500,650,185,60);
            add(BHow);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            g.setColor(Color.RED);
            g.setFont(new Font("supermarket", Font.PLAIN, 200));		
            g.drawString("Gunner D",70,200);	
            
	}
}