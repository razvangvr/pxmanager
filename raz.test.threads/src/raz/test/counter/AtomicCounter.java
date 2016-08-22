package raz.test.counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/atomicvars.html
 * 
 * http://www.vogella.com/tutorials/JavaConcurrency/article.html#memorymodel_atomic
 * */

public class AtomicCounter implements ICounter{

	
	private volatile AtomicLong counter = new AtomicLong(0);
	
	public void increment(){
		counter.incrementAndGet();
	}
	
	public long getCounterValue() {
        return counter.get();
    }

	
	
}
