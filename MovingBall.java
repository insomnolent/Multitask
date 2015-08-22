import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
//import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class MovingBall extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Timer t = new Timer(50, this);
	private int diff;
	double x = 0, y = 0, velx = 0, vely = 0;
//	Graphics2D g2;
	Timer timer;
	Timer t = new Timer(50, this);;
	private long time;
	private ArrayList<SquareTimer> sqrs = new ArrayList<SquareTimer>();
	
	/*
	ActionListener animate = new ActionListener() {
		
	    public void actionPerformed(ActionEvent ae) {
	        repaint();	              	    	
	    }        
	};
		
	ActionListener popUp = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			sqr = new SquareTimer();
			add(sqr);
			
			//if (sqr.gameOver() == true) {
				//t.stop();
			//}
		}
	};
	*/
	
	public MovingBall() {
		setOpaque(true);
		setBackground(new Color (120, 250, 140));
		setLayout(null);
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		diff=0;
		//setVisible(true);

		ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();                }
        };
        
		timer = new Timer (2000,animate);
		//timer.setDelay(100);
		
		timer.start();
		time = System.currentTimeMillis();
		
		/*
		Timer sqrTimer = new Timer(2000, popUp);
				sqrTimer.start();
		*/
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color (70, 240, 40));
		g2.fill(new Ellipse2D.Double(x, y, 40, 40));	
		
		int xCoor = (int) (Math.random()*660+20);
		int yCoor = (int) (Math.random()*460+20);
		
		if (System.currentTimeMillis()-time > 3000-diff*100) {
			sqrs.add(new SquareTimer(xCoor,yCoor));
			time = System.currentTimeMillis();
			diff++;
			if (diff > 20) {
				diff = 20;
			}
		}
		
		putSquare(g);
		
        if (sqrs.size() > 6) {
        	System.out.print("gameOver ");
        	t.stop();
        	timer.stop();
        }

		Toolkit.getDefaultToolkit().sync();
        g.dispose();
	}
	
	public void putSquare(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(new Color (70, 240, 40));
        g2.setStroke(new BasicStroke(4));
        
        
    	for(int j = sqrs.size()-1; j>0; j--){        
            SquareTimer place = sqrs.get(j);
            //JLabel clock = place.getJLabel();
           
            g2.drawRect(place.getX(), place.getY(), 60,60);
            
            if (collision(place) == true) {
            	sqrs.remove(j);
            	g2 = null;
            }
                    
    	}
    }
	    

	public void actionPerformed(ActionEvent e) {
			
		x += velx;
		y += vely;
		if (x <= 10) {
			x = 10;
		}
		if (x >= 790) {
			x = 790;
		}
		if (y <= 10) {
			y = 10;			
		}
		if (y >= 590) {
			y = 590;
		}
		
		repaint();
	
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			vely = -10.0;
		}
		if (code == KeyEvent.VK_S) {
			vely = 10.0;
		}
		if (code == KeyEvent.VK_A) {
			velx = -10.0;
		}
		if (code == KeyEvent.VK_D) {
			velx = 10.0;
		}
	}	

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			vely = 0;
		}
		if (code == KeyEvent.VK_S) {
			vely = 0;
		}
		if (code == KeyEvent.VK_A) {
			velx = 0;
		}
		if (code == KeyEvent.VK_D) {
			velx = 0;
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public boolean collision(SquareTimer s) {
		//for (int j = 0; j < sqrs.size(); j++) {
			Rectangle r1 = new Rectangle();
			r1.setBounds((int) x,(int) y, 35, 35);
			Rectangle r2 = new Rectangle();
			r2.setBounds(s.getX(), s.getY(),60,60);
			if (r1.intersects(r2)) {
				s.remove();
				return true;
			
			//}
		}
		return false;
	}

	/*
	public static void main(String[] args) {
		JFrame f = new JFrame();
		MovingBall r = new MovingBall();		
		f.add(r);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
	}
	*/
}


