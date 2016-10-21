package umarviktor.model;

/**
 *
 * @author Umar
 * @author Viktor
 * This class represents a generic Player
 */
public class Player {
    
    private String name;
    private String path;
    private int iD;
    private static int counterID=0;

    /**
     * Class constructor. Creates a new Player with default name, no image, and an unique ID
     */
    public Player(){
        name="Player";
        path="None";
        
        iD=counterID;
        counterID++;
    
    }
    
    /**
     * gets the ID of the player
     * @return the players ID
     */
    public int getID(){ // gets the ID of the player
        return iD; 
    
    }
    
    /**
     * sets the name of the player to a new one
     * @param name the new name
     */
    public void setName(String name){  //sets the name of the player to a new one
        this.name=name;
    }
    
    /**
     * sets the path to the players picture to a new one
     * @param path the new path
     */
    public void setPath(String path){ //sets the path to the players picture to a new one
        this.path=path;
    }
    
    /**
     * gets the path of the players image
     * @return the path to the image
     */
    public String getPath(){ //gets the path of the players image
        return path;
    }
    
    /** 
     * gets the players name
     * @return the players name
     */
    public String getName(){ //gets the players name
        return name;
    }
    /**
     * Creates a string representation of a player object containing relevant information about him
     * @return the players name, ID and the path to his image
     */
    public String toString(){ //Creates a string representation of a player object containing relevant information about him
        return name + " "+ iD + " " + path;		
    }
}
