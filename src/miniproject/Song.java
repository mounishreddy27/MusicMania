package miniproject;

public class Song 
{
	private String name;
    private double duration;
    public Song(String name, double duration) 
    {
        this.name = name;
        this.duration = duration;
    }
    public Song(String name) 
    {
        this.name = name;
    }
    public Song()
    {

    }
    public String getName() 
    {
        return name;
    }
    public double getDuration() 
    {
        return duration;
    }
    @Override
    public String toString() 
    {
        return "Song{" + "Name='" + name + '\'' + ", Duration=" + duration +'}';
    }
}
