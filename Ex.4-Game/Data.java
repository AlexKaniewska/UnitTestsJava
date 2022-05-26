import java.io.Serializable;
import java.util.*;

public class Data implements Serializable{
    private String general;
    private String action;
    private ArrayList<Soldier> army;

    public Data(String name, String action2, ArrayList<Soldier> army2){
        this.general = name;
        this.action = action2;
        this.army = army2;
    }

    public void setGeneral(String name){
        this.general = name;
    }

    public String getGeneral(){
        return this.general;
    }
    public void setMove(String new_action){
        this.action = new_action;
    }

    public String getMove(){
        return this.action;
    }

    public void setArmy(ArrayList<Soldier> new_army){
        this.army = new_army;
    }

    public ArrayList<Soldier> getArmy(){
        return this.army;
    }
}
