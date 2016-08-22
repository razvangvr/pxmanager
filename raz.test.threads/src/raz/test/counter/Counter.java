package raz.test.counter;

public class Counter implements ICounter{
	
	private long counter;
	
	public void increment(){
		counter++;
	}
	
	public long getCounterValue() {
        return counter;
    }


}
