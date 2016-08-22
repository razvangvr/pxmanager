package raz.test.counter;

import raz.callable.RazLongCalculationSubThread;

public class MyThread extends Thread{

	final ICounter counter;
	final int id;
	
	public MyThread(int id, ICounter counter){
		this.id = id;
		this.counter = counter;
	}
	
	@Override
	public void run() {		
		counter.increment();
		//RazLongCalculationSubThread.debugThreadInfo(String.valueOf(getCounter()));
		//RazLongCalculationSubThread.debugThreadInfo("MyCallable:"+id+" counter:"+getCounter());
	}
	
	public long getCounter(){
		return counter.getCounterValue();
	}
	
	
	public static void main(String args[]){
		testSyncVersion(100);
		//testUnSyncVersion(100);
	}
	
	static void testSyncVersion(int numerOfThreads){
		ICounter counter = new AtomicCounter();
		for(int i=1; i<=numerOfThreads; i++){
			MyThread t = new MyThread(i, counter);
			t.start();
		}
	}
	
	static void testUnSyncVersion(int numerOfThreads){
		Counter counter = new Counter();
		for(int i=1; i<=numerOfThreads; i++){
			MyThread t = new MyThread(i,counter);
			t.start();
		}
	}

}

 

