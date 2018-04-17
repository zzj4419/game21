package game21;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Main extends JFrame {
	Panel panel1=new Panel();
	JButton b1=new JButton("get one card");
	JButton b2=new JButton("done");
	JButton b3=new JButton("restart");
	JButton b4=new JButton("exit");
	public Main()
	{
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(b1);
		jp2.add(b2);
		jp2.add(b3);
		jp2.add(b4);
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel1,BorderLayout.CENTER);
		c.add(jp2, BorderLayout.SOUTH);
		this.setTitle("Game 21");
		this.setVisible(true);
		this.setBounds(100,100,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel1.card_to_p();
				if(panel1.c_tc&&panel1.p_l==false)
				{
					panel1.card_to_c();
				}
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				while(panel1.c_tc)
					panel1.card_to_c();
				if(panel1.c_l==false&&panel1.p_l==false)
					panel1.compare_score();
					
			}
		});
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel1.restart();
			}
		});
		b4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
	}
	public static void main(String[] args) {
		new Main();
	}
}
