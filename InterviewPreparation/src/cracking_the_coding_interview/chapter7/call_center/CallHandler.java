package cracking_the_coding_interview.chapter7.call_center;

import java.util.*;

public class CallHandler {

	private final int LEVEL = 3;
	
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;
	
	List<List<Call>> callQueues;
	
	public CallHandler() {}
	
	public Employee getHandlerForCall(Call cal) {}
	
	public void dispatchCall(Caller caller) {
		Call c = new Call(caller);
		dispatchCall(c);
	}
	
	public void dispathCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if (emp != null) {
			emp.recieveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("message");
			callQueue.get(cal.getRank().getValue()).add(call);
		}
	}
	
	public boolean assignCall(Employee emp) {};
}
