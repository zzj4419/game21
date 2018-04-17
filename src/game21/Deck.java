package game21;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Deck {
	String type;
	String num;
	int n;
	Image image;
	int pos_x=0;
	int pos_y=0;
	int h=80;
	int w=60;
	Image back = Toolkit.getDefaultToolkit().getImage("");
	public Deck(String string, String string2, Image image) {
		// TODO Auto-generated constructor stub
		this.type=string;
		this.num=string2;
		this.image=image;
		if(this.num=="J"||this.num=="Q"||this.num=="K")
			this.n=10;
		else if(this.num=="A")
			this.n=1;
		else
			this.n=Integer.parseInt(this.num);
	}
	public void setpos(int x,int y)
	{
		this.pos_x=x;
		this.pos_y=y;
	}
	public void drawcard(Graphics g, JPanel i)
    {
        g.drawImage(image, pos_x, pos_y, w,h, (ImageObserver) i);
    }
	public void drawcardback(Graphics g, JPanel i)
    {
        g.drawImage(back, pos_x, pos_y, w,h, (ImageObserver) i);
    }
	public int getvalue()
	{
		return this.n;
	}

}
