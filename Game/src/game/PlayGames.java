package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PlayGames extends JFrame implements ActionListener{  
	homesgames homesgames1 = new homesgames();
        how_to how_to1 = new how_to();
        stage1 stage_1 = new stage1();
	
	public PlayGames(){
		this.setSize(1000,800);        
		this.add(homesgames1);
                homesgames1.BStart.addActionListener(this);
                homesgames1.BHow.addActionListener(this);
                homesgames1.BExit1.addActionListener(this);
                how_to1.BBack.addActionListener(this);
               
	}
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== homesgames1.BHow){
		this.setLocationRelativeTo(null);
		this.remove(homesgames1);
                this.setSize(1000,800);
                this.add(how_to1);
                this.setLocationRelativeTo(null);
            	this.setFocusableWindowState(true);
                
            }
            else if(e.getSource() == how_to1.BBack){
			
				this.remove(how_to1);
				this.setSize(1000,800);
				getContentPane().add(homesgames1);
				this.setLocationRelativeTo(null);
				this.setFocusableWindowState(true);
				
			}
            else if(e.getSource() == homesgames1.BExit1){
		System.exit(0);
            }
             if(e.getSource()== homesgames1.BStart){
		this.setLocationRelativeTo(null);
		this.remove(homesgames1);
                this.setSize(1000,800);
                this.add(stage_1);
                stage_1.requestFocusInWindow();
		stage_1.timestart = false;	
		stage_1.HP =5;
		stage_1.times = 50;
  
		
            }
                this.validate();
    		this.repaint();
        }
                
    
        
          public static void main(String[] args) {
            JFrame jf = new PlayGames();
            jf.setSize(1000,800);
            jf.setTitle("Gunner D");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);

        
        
        }	
}
