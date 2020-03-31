import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class fontw extends JApplet {
String[] description;
   Font[] font;
   int i;
   String m="a";
   JTextArea t = new JTextArea(20,20);
  JComboBox c = new JComboBox();
  JLabel l=new JLabel("Fonts :");
  JComboBox d = new JComboBox();
  JButton b = new JButton();
  JButton a = new JButton();
  JLabel l1 = new JLabel("Font Size :");
  public void init() {
	  description = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      font = new Font[description.length];
	  t.setText("Enter any text");
	  b.setText("Bold");
	  a.setText("Italic");
    for (i = 0; i <description.length ; i++)
    {
      c.addItem(description[i]);
    }
    for (i = 15; i <105 ; i+=5)
    {
      d.addItem(i);
    }
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(m=="i")
        	{
        	t.setFont(new Font((String) c.getSelectedItem(), Font.BOLD+Font.ITALIC, 16));
        	m="bi";
        	}
        	else if(m=="a")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.BOLD, 16));
        		m ="b";
        	}
        	else if(m=="bi")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.ITALIC, 16));
        		m="i";
        	}
        	else if(m=="b")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.PLAIN, 16));
        		m="a";
        	}
        }
    });
    a.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(m=="b")
        	{        	
        		t.setFont(new Font((String) c.getSelectedItem(), Font.ITALIC+Font.BOLD, 16));
        		m="bi";
        	}
        	else if(m=="a")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.ITALIC, 16));
        		m="i";
        	}
        	else if(m=="bi")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.	BOLD, 16));
        		m="b";
        	}
        	else if(m=="i")
        	{
        		t.setFont(new Font((String) c.getSelectedItem(), Font.PLAIN, 16));
        		m="a";
        	}
        }
    });
    c.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                t.setFont(new Font((String) c.getSelectedItem(), Font.PLAIN, (int) d.getSelectedItem()));
            }
        }
    });
    d.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                t.setFont(new Font((String) c.getSelectedItem(), Font.PLAIN,(int) d.getSelectedItem()));
            }
        }
    });
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(t);
    cp.add(l);
    cp.add(c);
    cp.add(b);
    cp.add(a);
    cp.add(l1);
   cp.add(d);

  
  }

  public static void main(String[] args) {
    run(new fontw(), 200, 125);
  }

  public static void run(JApplet applet, int width, int height) {
    JFrame frame = new JFrame("Font Window");
    frame.getContentPane().add(applet);
    frame.setSize(width, height);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
}