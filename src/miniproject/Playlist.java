package miniproject;

interface Playlist 
{
	public Song findSong(String name);
	public boolean addSong(String name, double duration);
	public boolean addSong(String name);
}
