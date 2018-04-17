package game21;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;


public class Panel extends JPanel{
	int n=1;
	Base base=new Base();
	boolean p_l=false;
	boolean c_l=false;
	int p_t=0;
	int c_t=0;
	ArrayList p_a=new ArrayList();
	ArrayList c_a=new ArrayList();
	boolean c_tc=true;
	public Panel()
	{
		base.wash();
		this.setVisible(true);
		repaint();
	}
	public void paint(Graphics p)
	{
		p.clearRect(0,0,this.getWidth(),this.getHeight());
		p.drawString("computer", 400, 100);
		for(int i=0;i<c_a.size();i++)
		{
			Deck deck=(Deck)c_a.get(i);
			deck.setpos(50*i, 100);
			if(c_l==true||p_l==true)
			    deck.drawcard(p, this);
			else
				deck.drawcardback(p, this);
		}
		p.drawString("player", 400, 300);
		for(int i=0;i<p_a.size();i++)
		{
			Deck deck=(Deck)p_a.get(i);
			deck.setpos(i*50, 300);
			deck.drawcard(p, this);
		}
	}
	public void p_score()
	{
		p_t=0;
		for(int i=0;i<p_a.size();i++)
		{
			Deck deck=(Deck)p_a.get(i);
			p_t=p_t+deck.getvalue();
		}
	}
	public void c_score()
	{
		c_t=0;
		for(int i=0;i<c_a.size();i++)
		{
			Deck deck=(Deck)c_a.get(i);
			c_t=c_t+deck.getvalue();
		}
	}
	public void is_empty()
	{
		if(n>51)
		{
			n=1;
			base.wash();
		}
		else
			n++;
	}
	public void card_to_p()
	{
		p_a.add(base.getOneCard(n));
		p_score();
		repaint();
		is_empty();
		if(p_t>21)
		{
			p_l=true;
			repaint();
			JOptionPane.showMessageDialog(null, "you lose", null, JOptionPane.OK_OPTION);
			repaint();
		}
	}
	public void card_to_c()
	{
		c_a.add(base.getOneCard(n));
		c_score();
		repaint();
		is_empty();
		if(c_t>21)
		{
			 c_l=true;
			 c_tc=false;
			 JOptionPane.showMessageDialog(null, "you win", null, JOptionPane.OK_OPTION);
		}
		else if(c_t>17)
		{
			c_tc=false;
		}
	}
	public void compare_score()
	{
		this.p_score();
		this.c_score();
		if(p_t>c_t)
		{
			c_l=true;
			JOptionPane.showMessageDialog(null, "you win", null, JOptionPane.OK_OPTION);
		}
		else if(p_t==c_t)
		{
			JOptionPane.showMessageDialog(null, "draw", null, JOptionPane.OK_OPTION);
		}
		else if(p_t<c_t)
		{
			JOptionPane.showMessageDialog(null, "you lose", null, JOptionPane.OK_OPTION);
		}
	}
	public void restart()
	{
		c_t=0;
		p_t=0;
		c_l=false;
		p_l=false;
		c_tc=true;
		c_a.clear();
		p_a.clear();
		for(int i=0;i<2;i++)
		{
			card_to_p();
			card_to_c();
			repaint();
		}
	}
}
