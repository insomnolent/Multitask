import java.awt.*;

import javax.swing.*;

public class SquareTimer extends JPanel  {

private static final long serialVersionUID = 1L;
//private final int SECOND = 1000;
private JLabel clock = new JLabel();
private int count = 0;
Graphics2D sqr;

private int a;
private int b;

public SquareTimer(int x, int y) {

	a = x;
	b = y;
	count = 10;
   
	/*
	ActionListener animate = new ActionListener() {
		
	    public void actionPerformed(ActionEvent ae) {
	        //repaint();
	    	clock.setFont(new Font("Helvetica", Font.BOLD,18));
	    	clock.setForeground(new Color(70,240,30));
	        clock.setText(""+count);
	        clock.setBounds(new Rectangle(new Point(a+14,b+8), clock.getPreferredSize()));
	        count--;	               	
	        repaint();
	    }        
	};
	
    Timer t = new Timer(SECOND, animate);
    t.start();
    */
		        
	//setLayout(new FlowLayout());
	setLayout(null);
	setVisible(true);
}

public void decrCount() {
	count--;
}

/*
public void paintComponent(Graphics g) {
	
	super.paintComponent(g);
    g.setColor(new Color (70, 240, 40));

    sqr= (Graphics2D) g;
        
    sqr.setStroke(new BasicStroke(4));
	sqr.drawRect(a, b, 80, 80);
		        
	
}
*/

public int getX() {
	return a;
}


public int getY() {
	return b;
}

public int getCount() {
	return count;
}

public void remove() {
	
	//clock = null;
	//clock.setVisible(false);
}

public JLabel getJLabel() {
	return clock;
}



/*	
	ActionListener animate = new ActionListener() {
		public void actionPerformed(ActionEvent arg) {
		if (count < 0) {
	    	//gameOver();
	    	System.out.println("gameOver");
	    	t.stop();
	    }
		System.out.println(count + "");
		label.setFont(new Font("Helvetica", Font.BOLD,18));
		label.setForeground(new Color(70,240,30));
	    label.setText(""+count);
	    label.setBounds(new Rectangle(new Point(a+14,b+8), label.getPreferredSize()));
	    count--;
		}
		
	};
    t = new Timer(1000, animate);
    t.start();
    */

}


