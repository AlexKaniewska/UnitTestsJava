import java.util.*;

public class Report{
    String general;
    String action = "";
    ArrayList<Soldier> army;
    int power;
    
    public Report(String gen,  ArrayList<Soldier> lista){
        this.general = gen;
        this.army = lista;
    }

    public Report(String gen, int pow){
        this.power = pow;
        this.general = gen;
    }

	String myAction(){
		return "General  : " + general + "\n"+
        "did: " + action + "\n"+
        "with their army: " + army;
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

class Kill extends Report{
    Kill(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "killed soldier" + "\n"+
        "with their army: " + army;
	}	
}

class Buy extends Report{
    Buy(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "bought soldier" + "\n"+
        "with their army: " + army;
	}
}
class Attack extends Report{
	Attack(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "attacked" + "\n"+
        "with their army: " + army;
	}	
}

class Victory extends Report{
	Victory(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "won battle" + "\n"+
        "with their army: " + army;
	}
}

class Draw extends Report{
	Draw(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "had a draw" + "\n"+
        "with their army: " + army;
	}
}
class Maneuver extends Report{
    Maneuver(String gen,  ArrayList<Soldier> lista){
        super(gen, lista);
    }
    String myAction(){
		return "General  : " + general + "\n"+
        "did: " + "did maneuver" + "\n"+
        "with their army: " + army;
	}
} 

class Promotion extends Report{
    Promotion(String gen, int pow){
        super(gen, pow);
    }
    String myAction(){
		return "Soldier  : " + general + "\n"+
        "did: " + "promoted" + "\n"+
        "with their ability: " + power;
	}
}

class MinExp extends Report{
    MinExp(String gen, int pow){
        super(gen, pow);
    }
    String myAction(){
		return "Soldier  : " + general + "\n"+
        "did: " + "lost experience" + "\n"+
        "with their ability: " + power;
	}
}

class MaxExp extends Report{
    MaxExp(String gen, int pow){
        super(gen, pow);
    }
    String myAction(){
		return "Soldier  : " + general + "\n"+
        "did: " + "gain experience" + "\n"+
        "with their ability: " + power;
	}
}