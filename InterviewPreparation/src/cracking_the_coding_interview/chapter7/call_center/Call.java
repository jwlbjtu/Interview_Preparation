package cracking_the_coding_interview.chapter7.call_center;

public class Call {

	private Rank rank;
	
	private Caller caller;
	
	private Employee handler;
	
	public Call(Caller c) {
		caller = c;
	}
	
	public void setHadnler(Employee e) {
		handler = e;
	}
	
	public void reply(String m) {}
	public Rank getRank() {return rank;}
	public void setRand(Rank r) {rank - r;}
	public Rank incrementRank() {}
	public void disconnect() {}
}
