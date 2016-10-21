package umarviktor.model;

/**
 *
 * @author Umar
 * @author Viktor
 * This class represents a Football team
 */
public class Squad {

    private Player[] team;
/**
 * Class constructor. Creates a new team with 2 goalkeepers, 5 defenders, 5 midfielders and 3 strikers
 */
    public Squad() {     				 //Class constructor. Creates a new team with 2 goalkeepers, 5 defenders, 5 midfielders and 3 strikers
        team = new Player[15];
        
        for (int i = 0; i < 15; i++) { 
        if (i<2){
            team[i] = new GoalKeeper();
        }
        else if (i<7){
            team[i] = new Defender();
        }
        else if (i<12) {
            team[i] = new MidFielder();
            }
        else{
            team[i] = new Striker();
            }
    }
    }

    /**
     * gets the players of the team
     * @return the team
     */
    public Player[] getTeam() {
        return team;
    }
    
    /**
     * find a player by their unique ID
     * @param id the player's ID
     * @return the player with that ID
     */
    public Player search(int id){  //modified the method (removed some stuff that wasnt needed)
        for(Player player: team){
            if(player.getID()==id){
              return player;
            }
        }
        return null;
    }
}
