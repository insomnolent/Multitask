import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

import java.awt.geom.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;

public class MovingBlock extends JPanel implements ActionListener, KeyListener {

    private static final long serialVersionUID = 1L;
    private Timer t = new Timer(5, this);
    private Timer timer;
    private double x = 350, y = 350, vely = 0;
    private Rectangle2D rect;
    private int i = 0; int n = 0; int a = 0; int c = 0; int test = 0; int numArrows = 0;
    private ArrayList<triPoints> triPts = new ArrayList<triPoints>();
    private long time;
    int count = 0;
    
    
    

    public MovingBlock() {
        setOpaque(true);
        setBackground(new Color(159, 179, 243));
        t.start();
        addKeyListener(this);
        setVisible(true);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        ActionListener animate = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    repaint();                }
            };
        int rand = (int) (Math.random()*5+1);
        timer = new Timer (rand*100,animate);
        //timer.setDelay(100);

        timer.start();
        time = System.currentTimeMillis();
        

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(347, 64, 26, 425);
        g2.setColor(new Color(0, 0, 204));
        rect = new Rectangle2D.Double(x, y, 20, 70);
        g2.fill(rect);
        
        test = (int) (Math.random()*2+1); //direction of shape

        //g.setColor(new Color(160-n, 160-n, 204)); 
        /*
        if (n == 160) {
            g.setColor(new Color(0,0,204));
        }
		*/
        g.setColor(Color.red);
        int[] xPt1 = {(60+i), (85+i), (60+i), 60+i};
        int[] xPt2 = {650-i, 623-i, 650-i, 650-i};
        
        if(System.currentTimeMillis()-time>150 && numArrows<=3){
            c = (int) (Math.random()*5+1); //arrows y loc 
            int[] yPt = {80+c*50, 100+c*50, 120+c*50, 80+50*c};
            if (test==1) {
                triPts.add(new triPoints(xPt1,yPt,0));                
                numArrows++;
            }
            else {
                triPts.add(new triPoints(xPt2,yPt,0));
                numArrows++;
            }
            time = System.currentTimeMillis();
        }
        
       
            changeColor(g);
            i+=2;
            if (n < 160) {
                n += 10;
            		}
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }   
		
    public void changeColor(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	for(int j = triPts.size()-1; j>0; j--){        
            triPoints place = triPts.get(j);
            
            if(place.getX()[0] > 650 || place.getX()[0] == 0)
            {
            	triPts.remove(j);
            	numArrows--;
            }     	
            
            else{
            g2.fillPolygon(place.getX(), place.getY(), 4);
            place.move();
            
            if(place.getLength()>60)
            {
                if (a < 160) {    
                    //g2.setColor(new Color(a, a, 204)); 
                    //g2.fillPolygon(place.getX(), place.getY(), 4);
                    a += 1;
                }
                if (a == 160) {

                   // g2.setColor(new Color(159, 179, 243));
                    //g2.fillPolygon(place.getX(), place.getY(), 4);
                    

                    i = 0;
                }
            }
                
            }
         }
       }
    
   
    public boolean collision()
    {
        boolean gameIsOver = false;
        
        if(numArrows > 0){
        for(int a = 1; a<=numArrows; a++){
        	triPoints pts = triPts.get(a-1);
        	Rectangle triangle = new Rectangle(pts.getX()[0]-6,pts.getY()[1]-5,28, 40);
        	if(rect.intersects(triangle))
        		gameIsOver = true;
        	}
        }
     return gameIsOver; 
        
    }

    public void actionPerformed(ActionEvent e) {
        if(collision() == false)
        {
            repaint();

            if(y >= 400) {
                y = 400;
            }
            if(y<= 80) {
                y = 80;
            }
            y += vely;
        }
        else
        {
        	t.stop();
        	timer.stop();
        	System.out.print("Game Over");
        }
    }


    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            vely = -2.0;
        }
        if (code == KeyEvent.VK_DOWN) {
            vely = 2.0;
        }
    }

	public void keyReleased(KeyEvent e) 
	{
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
            vely = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            vely = 0;
        }		
	}

	public void keyTyped(KeyEvent arg0) {}
	
	/*
	public static void main(String[] args) {
		JFrame f = new JFrame();				
		MovingBlock s = new MovingBlock();		
		f.add(s);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);

	}
	*/
}