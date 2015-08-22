import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MoveTriangle extends JPanel
{
    int i = 0;
    int n = 0;
    int a = 0;
	private static final long serialVersionUID = 1L;
	
    public MoveTriangle() {
    	
    	setBackground(new Color(159, 179, 243));
        ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        Timer timer = new Timer(70,animate);
        timer.start();
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(160-n, 160-n, 204)); 
        if (n == 160) {
        	g.setColor(new Color(0,0,204));
        }

        Graphics2D poly = (Graphics2D) g;
        
        int[] xPt = {20+i, 45+i, 20+i, 20+i};
        int[] yPt = {80, 100, 120, 80};
        
        poly.fillPolygon(xPt, yPt, 4);

        i+=2;
        if (i>60){       	
        	
        	if (a < 160) {    
        		g.setColor(new Color(a, a, 204)); 
            	g.fillPolygon(xPt, yPt, 4);
            	a += 20;
        	}
        	if (a == 160) {
        		g.setColor(new Color(159, 179, 243));
        		g.fillPolygon(xPt, yPt, 4);
        	}
        }
        if (n < 160) {
        n += 20;
        }
    }
}

