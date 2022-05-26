import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class General implements Observable, Serializable{
    private String name;
    private Double money = 1000.0;
    private ArrayList<Soldier> army;
    private ArrayList<Listener> listeners;
    
    public General(String name2){
        this.name = name2;
        this.army = new ArrayList<Soldier>();
        this.listeners = new ArrayList<Listener>();
    }

    //set/get
    public void setName(String name2){
        this.name = name2;
    }

    public String getName(){
        return this.name;
    }

    public void setMoney(Double money2){
        this.money = money2;
    }

    public Double getMoney(){
        return this.money;
    }

    public void setArmy(ArrayList<Soldier> army2){
        this.army = army2;
    }

    public ArrayList<Soldier> getArmy(){
        return this.army;
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


    //manewr armii - lub czesci
    public void army_maneuver_all(){
        int price = 0;
        for(Soldier soldier : this.army){
            price = price + soldier.getRank().getNumber();
        }
        if(this.money >= price){
            this.setMoney(this.getMoney() - price);
            for(Soldier soldier : this.army){
                soldier.addExperience();
            }
        }

        Report tool = new Maneuver(this.name, this.army);
        notify(tool);
    }

    public void army_maneuver_some(ArrayList<Integer> lista){
        int price = 0;
            for(Integer i : lista){
                if(i < this.army.size()){
                    price = price + this.army.get(i).getRank().getNumber();
                }
            }
        
        if(this.money >= price){
            for(Integer i : lista){
                if(i < this.army.size()){
                    this.army.get(i).addExperience();;
                }
            }
        }

        Report tool = new Maneuver(this.name, this.army);
        notify(tool);
    }

    //kupienie żołnierza
    public void buy_soldier(Rank rank){
        int price = rank.getNumber()*10;
        if(this.money >= price){
            this.setMoney(this.getMoney() - price);

            Soldier soldier = new Soldier(rank);
            this.army.add(soldier);
            Report tool = new Buy(this.name, this.army);
            notify(tool);
        }


    }

    //losowe/lub nie zabicie żołnierza
    public void kill_soldier(int index){
        if(index < this.army.size()){
            this.army.remove(index);
            Report tool = new Kill(this.name, this.army);
            notify(tool);
        }
        
    }


    //atak
    public void attack(General g2){

        Report tool = new Attack(this.name, this.army);
        notify(tool);

        int power1 = 0;
        int power2 = 0;
        for(Soldier soldier : this.army){
            power1 = power1 + soldier.getPower();
        }
        for(Soldier soldier : g2.army){
            power2 = power2 + soldier.getPower();
        }

        if(power1 > power2){
            Double procent = 0.1*g2.money;
            this.setMoney(this.getMoney() + procent);
            g2.setMoney(g2.getMoney() - procent);
            for(Soldier soldier : this.army){
                soldier.addExperience();
            }

            for(Soldier soldier : g2.army){
                soldier.minusExperience();
            }

            checkZeroExp(g2);
            Report tool1 = new Victory(this.name, this.army);
            notify(tool1);
        }
        else if(power1 == power2){
            int randomNum1 = ThreadLocalRandom.current().nextInt(0, this.army.size());
            int randomNum2 = ThreadLocalRandom.current().nextInt(0, g2.army.size());
            this.kill_soldier(randomNum1);
            g2.kill_soldier(randomNum2);

            Report tool1 = new Draw(this.name, this.army);
            notify(tool1);
            Report tool2 = new Draw(g2.name, g2.army);
            notify(tool2);
        }
        else {
            Double procent = 0.1*this.money;
            this.setMoney(this.getMoney() - procent);
            g2.setMoney(g2.money + procent);

            for(Soldier soldier : g2.army){
                soldier.addExperience();
            }

            for(Soldier soldier : this.army){
                soldier.minusExperience();
            }

            
            checkZeroExp(this);
            
            Report tool1 = new Victory(g2.name, g2.army);
            notify(tool1);
        }

    }

    public void checkZeroExp(General gen){
        for(Soldier soldier : gen.getArmy()){
            if(soldier.getExperience() == 0){
                gen.army.remove(soldier);
            }
        }
    }


    public void saveStatus(){
        try {
 
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Aleksandra\\Desktop\\Studia-4sem\\Program_ob-fun\\zad3-gra\\file.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            String info = "General: " + this.name + "  Army: " + this.army + "  Money: " + this.money + "  Listeners: " + this.listeners;
            objectOut.writeObject(info);
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Object getStatus(){
        try {
 
            FileInputStream fileIn = new FileInputStream("C:\\Users\\Aleksandra\\Desktop\\Studia-4sem\\Program_ob-fun\\zad3-gra\\file.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
