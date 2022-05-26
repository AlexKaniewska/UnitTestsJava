import java.io.Serializable;
import java.util.*;

public class Soldier implements Serializable, Observable {
    private Rank rank;
    private int experience;
    private int power;
    private ArrayList<Listener> listeners;

    //init
    public Soldier(Rank rank2){
        this.rank = rank2;
        this.experience = 1;
        this.power = rank2.getNumber() * this.experience;
        this.listeners = new ArrayList<Listener>();
    }

    //set/get
    public void setRank(Rank rank2){
        this.rank = rank2;
        this.changePower();
    }

    public Rank getRank(){
        return this.rank;
    }

    public void setExperience(int exp){
        this.experience = exp;
        if(this.rank.getNumber()*5 <= this.experience){
            this.promotion();
            this.experience = 1;
        }
        this.changePower();
    }

    public int getExperience(){
        return this.experience;
    }

    public int getPower(){
        return this.power;
    }

    public void setListeners(ArrayList<Listener> listeners2){
        this.listeners = listeners2;
    }

    public ArrayList<Listener> getListeners(){
        return this.listeners;
    }

    @Override
    public void add(Listener listener){
        this.listeners.add(listener);
    }

    @Override
    public void delete(Listener listener){
        int i = listeners.indexOf(listener);
		if (i >= 0) {
			this.listeners.remove(i);
		}
    }

    @Override
    public void notify(Report data){
        for(Listener listener : this.listeners){
            listener.addAction(data);
        }
    }


    //reszta
    public void changePower(){
        this.power = this.rank.getNumber() * this.experience;
    }

    public void addExperience(){
        this.experience = this.experience + 1;
        if(this.rank.getNumber()*5 <= this.experience){
            this.promotion();
            this.setExperience(1);
        }
        this.changePower();

        Report tool = new MaxExp(this.getRank().getTitle(), this.power);
        notify(tool);
    }

    public void minusExperience(){
        this.experience = this.experience - 1;
        this.changePower();

        Report tool = new MinExp(this.getRank().getTitle(), this.power);
        notify(tool);
    }

    public void promotion(){
        if(this.rank.getTitle() == "Szeregowy"){
            this.rank = new Rank("Kapral");

            Report tool = new Promotion(this.getRank().getTitle(), this.power);
            notify(tool);
        }
        else if(this.rank.getTitle() == "Kapral"){
            this.rank = new Rank("Kapitan");

            Report tool = new Promotion(this.getRank().getTitle(), this.power);
            notify(tool);
        }
        else if(this.rank.getTitle() == "Kapitan"){
            this.rank = new Rank("Major");
            
            Report tool = new Promotion(this.getRank().getTitle(), this.power);
            notify(tool);
        }

    }

}