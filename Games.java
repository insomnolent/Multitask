
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Games extends JFrame implements ActionListener 
{
	public int howMany;
	private Timer timer;
	private JButton gameOver;
	private JLabel clock;
	private int score;
	private final int SECOND = 1000;
	private int count;
	ActionListener updateClockAction = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			score++;
			count++;
			clock.setText("Score: " + score); 
		}
	};
	
	
	public Games()
	{
		super("GAME");
		
		Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
		howMany = 1;
		count = 0;
		score = 0;
		timer = new Timer(SECOND, updateClockAction);
		gameOver = new JButton("Game Over");
		clock = new JLabel("Score:");
		//Game1 = new Game1;
		
		container.add(clock);
		setSize(1100, 950);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        if(count == 20)
        {
        	addGame();
        	count = 0;
        }
        timer.start();
	}
	
	public static void main(String args)
	{
		Games game = new Games();
	}
	
	public void showGameOverScreen()
	{
		//in game classes, implement in their specific way so that gameOver executes when lost
	}
	
	public void gameOver()
	{
		
		//end the game
	}
	
	public void update()
	{
		howMany++;
		addGame();
		//JButton to pause the game, click/any key to resume?
	}
	
	public void addGame()
	{
		if(true) //Game3 exists
		{
			//Game4 = new Game4
			//scaleGames()
		}
		else if(true) //Game2 exists
		{
			//Game3 = new Game3
			//scaleGames()
		}
		else if(true) //Game1 exists
		{
			//Game2 = new Game2
			//scaleGames()
		}
	}
	
	public void scaleGames()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
