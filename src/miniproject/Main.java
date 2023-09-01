package miniproject;
import java.util.*;
public class Main {
	static char c;
	static int op;

	private static LinkedList<PlaylistImpl> pls = new LinkedList<>();
	
	public static void main(String[] args) {
		PlaylistImpl pl = new PlaylistImpl("Devotional");

        pl.addSong("Vishnu Sahasranamam",29.45);
        pl.addSong("Kalabairavashtakam",5.28);
        pl.addSong("Hanuman Chalisa",9.29);
        pl.addSong("Karavalamba Stotram");
        pls.add(pl);

         pl= new PlaylistImpl("Old songs");

        pl.addSong("Asalem Gurthukuradhu",5.50);
        pl.addSong("Singarala",5.28);
        pl.addSong("Mustafa Mustafa",6.05);
        pl.addSong("Vaalu kanuladaanaa");

        pls.add(pl);
        System.out.println("\n\n\n\t\t\t MUSIC PLAYER\n");
        do {
        System.out.print("\n\t\t1.Create Playlist\n\t\t2.Add To Playlist\n\t\t3.play Playlist\n\t\t4.Remove Playlist\n\t\t5.Exit\n");
        System.out.print("\n\t\tEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt();
        switch (op) {
        case 1:
        	createPlaylist(pl);         	
        	break;        	
        case 2:
        	System.out.println("\n\t Playlist's:");
           	addToPlaylist();
			System.out.println("\tSuccsessfully added Song\n");
        	break;       	
        case 3:
        	System.out.println("\n\t Playlist's:");
        	playPlaylist();
        	break;        	
        case 4:
        	System.out.println("\n\t Playlist's:");
        	removePlaylist();           	
        	break;        	
        case 5:
        	System.out.println("End...");
        	break;
        }       
    }while(op!=5);
	}
	
	public static void createPlaylist(PlaylistImpl p) 
	{
		System.out.print("\n\tEnter the Playlist name: ");
    	Scanner scan=new Scanner(System.in);
    	String n= scan.nextLine();
      	p= new PlaylistImpl(n);
    	do 
    	{
    		System.out.print("\n\tEnter the Song name: ");
    		Scanner s=new Scanner(System.in);
        	String sn= s.nextLine();
        	try 
        	{
        		int count=specialChar(sn);
        		if(count!=0)
        			throw new Exception("\tEnter a valid song");
        		System.out.print("\tEnter the Duration of Song: ");
        		Scanner d=new Scanner(System.in);
        		double t=d.nextDouble();
        		p.addSong(sn, t);
        		System.out.print("\tDo you want to continue to "
        				+ "add Sond? press 'y' for yes: ");
        		c=d.next().charAt(0);
        	}
        	catch(Exception e)
        	{
        		System.out.println(e.getMessage());
        	}
    		
    	}while(c=='y'||c=='Y');
    	pls.add(p);
	}
	public static void addToPlaylist() 
	{
		ListIterator<PlaylistImpl> litr= pls.listIterator();
    	ListIterator<PlaylistImpl> itr=pls.listIterator();
    	while(litr.hasNext())
    	{
    		String element=litr.next().name;
    		System.out.println("\t"+litr.nextIndex()+". "+element);
    	}
    	System.out.print("\n\tEnter the playlist name: ");
    	Scanner d=new Scanner(System.in);
    	String e=d.nextLine();
    	while(itr.hasNext())
    	{
    		String ls=itr.next().name;
    		if(ls.equals(e)) {   			
        		System.out.print("\n\tEnter the Song name: ");
    			String sn=d.nextLine();
    			try {
    				int count1=specialChar(sn);
    			if(count1!=0)
    				throw new Exception("\tEnter a valid song");
    			System.out.print("\tEnter the Duration of Song: ");
        		double sd=d.nextDouble();
        		int ip=itr.nextIndex();
        		//System.out.println(ip);
        		//Playlist p=pls.get(ip-1);
        		pls.get(ip-1).addSong(sn, sd);
    			}
    			catch(Exception e1) {
    				System.out.println(e1.getMessage());
    			}
        	}
    	}
	}
	public static void playPlaylist() {
		ListIterator<PlaylistImpl> litr1= pls.listIterator();
    	ListIterator<PlaylistImpl> itr1=pls.listIterator();
    	while(litr1.hasNext())
    	{
    		String element=litr1.next().name;
    		System.out.println("\t"+litr1.nextIndex()+". "+element);
    	}
    	System.out.print("\n\tEnter the playlist name: ");
    	Scanner d1=new Scanner(System.in);
    	String e1=d1.nextLine();
    	while(itr1.hasNext())
    	{
    		String ls1=itr1.next().name;
    		if(ls1.equals(e1)) {        		
        		int ip1=itr1.nextIndex();
        		//System.out.println(ip1);
        		//Playlist p=pls.get(ip1-1);
        		play(pls.get(ip1-1).songs);
    		}
        }
	}	
	public static void removePlaylist() {
		ListIterator<PlaylistImpl> litr2= pls.listIterator();
    	ListIterator<PlaylistImpl> itr2=pls.listIterator();
    	while(litr2.hasNext())
    	{
    		String element=litr2.next().name;
    		System.out.println("\t"+litr2.nextIndex()+". "+element);
    	}
    	System.out.print("\tEnter the playlist name: ");
    	Scanner d2=new Scanner(System.in);
    	String e2=d2.nextLine();
    	while(itr2.hasNext())
    	{
    		String ls2=itr2.next().name;
    		if(ls2.equals(e2)) {        		
        		int ip2=itr2.nextIndex();
        		//System.out.println(ip1);
        		//Playlist p=pls.get(ip1-1);
        		pls.remove(ip2-1);
    		}
    	}	
	}	
    private static void play(LinkedList<Song> PlaylistImpl){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = PlaylistImpl.listIterator();

        if(PlaylistImpl.size() == 0){
            System.out.println("\tThis playlist have no songs");
        }else {
            System.out.println("\tNow playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
        	System.out.print("\tEnter your choice: ");
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){                
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("\tNow playing "+listIterator.next().toString());
//                        System.out.println(listIterator.nextIndex());
                    }else {
                        System.out.println("\tno songs availble, reached to the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
//                            System.out.println(listIterator.nextIndex());
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("\tNow playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("\twe are at the first song of the playlist");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("\tNow playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("\twe are at the first song of the playlist");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("\tnow playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("\tno songs available, reached to the end of playlist");
                        }
                    }
                    break;
                case 4:
                    printList(PlaylistImpl);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (PlaylistImpl.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("\tnow playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("\tnow playing "+listIterator.previous().toString());
                        }
                    }
                    break;
                case 7:
//                    System.out.println("Playlist complete");
                    quit = true;
                    break;
            }
        }
    }
    public static int specialChar(String s) {
    	int count = 0;    	          
        for (int i = 0; i < s.length(); i++) {  
            // Checking the character for not being a
            // letter,digit or space
            if (!Character.isDigit(s.charAt(i))
                && !Character.isLetter(s.charAt(i))
                && !Character.isWhitespace(s.charAt(i))) {
                // Incrementing the counter for spl
                // characters by unity
                count++;
            }
        }
        return count;
    }
    private static void printMenu(){
        System.out.println("\n\tOptions");
        System.out.println( "\t1 - to play next song\n"+
                "\t2 - to play previous song\n"+
                "\t3 - to replay the current song\n"+
                "\t4 - list of all songs \n"+
                "\t5 - print all available options\n"+
                "\t6 - delete current song\n"+
                "\t7 - to quit\n");
    }
    private static void printList(LinkedList<Song> PlaylistImpl){
        Iterator<Song> iterator = PlaylistImpl.iterator();
        System.out.println("\t------------------------");

        while (iterator.hasNext()){
            System.out.println("\t"+iterator.next());
        }

        System.out.println("\t------------------------");
    }
}
