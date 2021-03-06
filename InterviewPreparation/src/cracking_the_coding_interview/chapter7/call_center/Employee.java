package cracking_the_coding_interview.chapter7.call_center;

public abstract class Employee {

	private Call currentCall = null;
	protected Rank rank;
	
	public Employee(CallHandler handler) {}
	
	public void receiveCall(Call call) {}
	
	public void callComplete() {}
	
	public void escalateAndReassign() {}
	
	public boolean assignNewCall() {}
	
	public boolean isFree() {return currentCall == null}
	
	public Rank getRank() {return rank;}
} 
