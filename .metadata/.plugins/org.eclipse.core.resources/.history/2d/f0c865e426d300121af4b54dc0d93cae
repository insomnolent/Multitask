
public class GameTimer {
	
	//number of nanoseconds in a second
	private final int NANOSECONDS = 1000000000;
	
	private boolean timerStarted;
	private int fpsCap, fps;
	private long beginTime, timeDifference;

	public GameTimer(int desiredFPS) 
	{
		fpsCap = desiredFPS;
		fps = 0;	
		timerStarted = false;
		beginTime = 0;
		timeDifference = 0;
	}

	//timer is re-started at the beginning of every loop cycle
	public void start() 
	{
		timerStarted = true;
		beginTime = System.nanoTime();
	}

	public void stop() 
	{
		timerStarted = false;
		beginTime = 0;
	}

	public void syncTime() 
	{
		if (timerStarted == true) 
		{
			timeDifference = System.nanoTime() - beginTime;
		}
		else 
		{
			timeDifference = 0;
		}
	
		if ( (timerStarted == true) && (timeDifference < (NANOSECONDS / fpsCap)) ) 
		{
			try 
			{
				Thread.sleep( 1000 * (NANOSECONDS - (timeDifference * fpsCap)) / fpsCap / NANOSECONDS);				
			}
			catch (InterruptedException e) 
			{
				System.out.println("Exception e");
			}
		}

		timerStarted = false;
		beginTime = 0;
		timeDifference = 0;
	}

	public int getFPS() 
	{
		return fps;
	}

}