package java_book.synch;

public class Sync {
	
	public static void main(String[] args){
		CallMe target = new CallMe();
		
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}catch (InterruptedException e){
			System.out.println("interrupted");
		}
	}
}
