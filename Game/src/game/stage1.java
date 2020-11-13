package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class stage1 extends JPanel  {
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("homeBackground.jpg"));
    private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("homeBackground.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("lv2.jpg"));
	Gunner m = new Gunner();
        GunnerL d = new GunnerL();
        
	homesgames hg = new homesgames();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("gameover.png"));
        ImageIcon feildvictory = new ImageIcon(this.getClass().getResource("victory_backgroud.jpg"));
        public ArrayList<bullet1> fireball = new ArrayList<bullet1>();
        public ArrayList<enemy1> ea1 = new ArrayList<enemy1>();
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("start.png"));
      
	
        
	boolean walk = false;
        boolean  r = true;
        boolean l = false;
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	boolean timestart = true;
        boolean start = false;
	public int eHP = 20;
	private Gameover gover = new Gameover();
	
	
	Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
     Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;                 
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
        
    
	
	stage1(){
		this.setFocusable(true);
		this.setLayout(null);
		ea1.add(new enemy1());
		
		this.addKeyListener(new KeyAdapter(){
                    
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			{
			    if(a==KeyEvent.VK_LEFT){
			     	m.x-=10;
                                m.count++;
                                r = false;
                                l = true;
                                walk = true;
                            }
                            else if(a == KeyEvent.VK_RIGHT){
                               m.x+=10;
                               m.count++;
                               r = true;
                               l = false;
                               walk = true;
			   }
                            if(m.count>2){
                                m.count=0;
                            }
                               else if(a == KeyEvent.VK_Z){
                               m.count=3;                            
			       fireball.add(new bullet1(m.x));
                               walk = false;
                          
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		
		m.x = 400;
		time.start();
		actor.start();
		t.start();
		
	}
	
	
	
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(times <= 0 || HP<=0){
                this.setLayout(null);
                time.stop();
                actor.stop();
                t.stop();
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
		g.setColor(Color.BLACK);
			  
            }
            else if(eHP <= 0 )
                {   
                    this.setLayout(null);
                    g.drawImage(feildvictory.getImage(),0,0,1000,800,this);
                    g.setFont(new Font("supermarket", Font.PLAIN, 150));
                    g.setColor(Color.BLUE);
                    g.drawString("Game Clear",100,150);
                    time.stop();
                    actor.stop();
                    t.stop();
                }
             else{
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                if(r==true){
                g.drawImage(m.im[m.count].getImage(), m.x, 550,110,160, this);
                }
                else if(l == true)
                {
                    g.drawImage(d.im[m.count].getImage(), m.x, 550,110,160, this);
                }
		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
             
                   if(l==true) {
               for(int i=0;i<fireball.size();i++){
                    bullet1 ba = fireball.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, 625,50,50, null);        
      		    ba.moveL();
      		    ba.count++;
      		    if(ba.x>1000||walk==true){
      		    	fireball.remove(i);
      		    }
   		}
                   }
                   else if(r == true){
                for(int i=0;i<fireball.size();i++){
                    bullet1 ba = fireball.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, 625,50,50, null);        
      		    ba.moveR();
      		    ba.count++;
      		    if(ba.x>1000||walk==true){
      		    	fireball.remove(i);
      		    }
   		}
                   }
                
                //===========enemy1================
		
                for(int i=0 ; i<ea1.size();i++){
                    g.drawImage(ea1.get(i).getImage(),ea1.get(i).getX(),ea1.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<ea1.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),ea1.get(j).getbound())){
			    fireball.remove(i);
                            eHP -=1;
			} 
		    }
		}
            
                   
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLUE);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STAGE "+rs1,350,80);
		g.drawString("Time "+times,350,150);
		g.setColor(Color.RED);
		g.drawString("HP  "+HP,50,100);
                g.drawString("Enemy HP  "+eHP,650,100);
		      
	    }

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
	
        
        
}
