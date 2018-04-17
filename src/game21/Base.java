package game21;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
public class Base {
	static int n=52;
	String type[]= {"red_1","red_2","bla_1","bla_2"};
	String num[]= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	Image image[]=new Image[n];
	static Deck deck[]=new Deck[n];
	public void get_image()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
				image[13*i+j]=Toolkit.getDefaultToolkit().getImage("");
		}
	}
	public void wash()
	{
		Random r=new Random();
		for(int i=0;i<52;i++)
		{
			int c=r.nextInt(52);
			Deck temp=deck[c];
			deck[c]=deck[i];
			deck[i]=temp;
		}
	}
	public Base()
	{
		this.get_image();
		for(int i = 0; i < 4; i++)
        {
             for(int j = 0; j < 13; j++)
            {
                deck[i*13+j] = new Deck(type[i], num[j], image[i*13+j]);
            }
        }
	}
	public Deck getOneCard(int n)//获取一张扑克牌对象
    {
        return Base.deck[n-1];
    }
}
