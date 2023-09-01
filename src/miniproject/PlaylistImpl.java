package miniproject;
import java.util.LinkedList;

public class PlaylistImpl implements Playlist 
{
	public String name;
    public LinkedList<Song> songs;
    public PlaylistImpl(String name) 
    {
        this.name = name;
        this.songs = new LinkedList<Song>();
    }
    public PlaylistImpl()
    {

    }
    public Song findSong(String name)
    {

        for(Song checkedSong : songs)
        {
            if(checkedSong.getName().equals(name)) return checkedSong;
        }
        return null;
    }
    public boolean addSong(String name, double duration)
    {
        if(findSong(name) == null)
        {
            songs.add(new Song(name,duration));
//            System.out.println(name + "successfully added to the list");
            return true;
        }
        else
        {
            System.out.println("\tSong with name "+ name+ " already exist in the list");
            return false;
        }
    }    
    public boolean addSong(String name)
    {
        if(findSong(name) == null)
        {
            songs.add(new Song(name));
//            System.out.println(name + "successfully added to the list");
            return true;
        }
        else 
        {
            System.out.println("\tSong with name "+ name+ " already exist in the list");
            return false;
        }
    }
}
