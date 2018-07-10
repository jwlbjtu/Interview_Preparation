package cracking_the_coding_interview.chapter7.jukebox;

public class CDPlayer {
	private CD cd;
	private Playlist p;
	
	public CDPlayer(CD cd, Playlist p) {}
	public CDPlayer(Playlist p) {this.p = p;}
	public CDPlayer(CD c) {cd = c;}
	
	public void playSong(Song s) {}
	
	public Playlist getPlaylist() {return p;}
	public void setPlaylist(Playlist p) {this.p = p;}
	
	public CD getCD() {return cd;}
	public void setCD(CD c) {cd = c;}
}
