package game;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Gunner{
    public ImageIcon[] im = new ImageIcon[4];
    public int x;
    public int count = 0;
    Gunner(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource("walkR0"+(i+1)+".jpg"));
	}
    }
}
