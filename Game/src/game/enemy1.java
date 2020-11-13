package game;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class enemy1 {
	Image img;
	public int x = 0;
	public int y= 575;
	public int count = 0;
        public int speed =1;
	enemy1(){
                String imageLocation = "e1.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x += speed;
                    if(x > 1000){
			speed = -1;
			
                    }
                    else if(x<0)
                    {
                        speed = 1;
                    }
                       
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,625,45,45));
	}
}
