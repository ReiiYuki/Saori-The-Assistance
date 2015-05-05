package Event;
/**
* A StopWatch that measures elapsed time between a starting time
* and stopping time, or until the present time.
* @author Voraton Lertrattanapaisal
* @version 1.0
*/
public class StopWatch {
	/** constant for converting nanoseconds to seconds. */
	private static final double NANOSECONDS = 1.0E-9;
	/** time that the StopWatch was started, in nanoseconds. */
	private long startTime;
	/** time that the StopWatch was stopped, in nanoseconds. */
	private long stopTime;
	/**
	 * To create the StopWatch.
	 */
	public StopWatch(){
		startTime = 0;
		stopTime = 0;
	}
	/**
	 * Get the elapsed time in seconds.
	 * @return the elapsed time in seconds.
	 */
	public double getElapsed() {
		if (isRunning()){
			return (System.nanoTime()-startTime)*NANOSECONDS;
		}
		else { 
			return (stopTime-startTime)*NANOSECONDS;
		}
	}
	/**
	 * To check if the StopWatch is running. 
	 * @return true if the StopWatch is running
	 */
	public boolean isRunning(){
		if (stopTime>0||startTime==0){
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * To start the StopWatch. 
	 * If the StopWatch start already, reseting the StopWatch.
	 */
	public void start(){
		startTime = System.nanoTime( );
		stopTime = 0;
	}
	/**
	 * To stop the StopWatch
	 */
	public void stop(){
		stopTime = System.nanoTime();
	}
	
}