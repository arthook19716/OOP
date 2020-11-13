package game;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bullet1 extends JPanel{
    public ImageIcon[] imfire = new ImageIcon[5];
    public int x;
    public int count=0;
    bullet1(int x){
        for(int i=0;i<imfire.length;i++){
            String imageLocation = "b"+(i+1)+".png";
            imfire[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
           
    }
	
    public void moveR(){
        {
	this.x+=3;
        }
    }
    
    public void moveL(){
        {
	this.x-=3;
        }
    }
    
   
    
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,625,25,25));
    }
}
