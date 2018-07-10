package cracking_the_coding_interview.chapter7.jukebox;

public class JukeBox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollections;
	private SongSelector ts;
	
	public Jukebox(CDPlayer cdPalyer, User user, Set<CD> cdColleciton, SongSelector ts) {}
	
	public Song getCurrentSong() {return ts.getCurrentSong();}
	public void setUser(User u) {this.user = u;}
}
