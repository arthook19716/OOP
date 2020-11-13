package game;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class GunnerL{
    public ImageIcon[] im = new ImageIcon[4];
    public int x;
    public int count = 0;
    GunnerL(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource("walkL0"+(i+1)+".jpg"));
	}
    }
}
