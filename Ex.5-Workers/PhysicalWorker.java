import java.lang.Math;

public class PhysicalWorker extends Worker {
    private int strength;

    PhysicalWorker(String name, String surname, int age, int experience, Address address, int strength2){
        super(name, surname, age, experience, address);
        this.strength = strength2;
    }

    public void setStrength(int str){
        this.strength = str;
    }

    public int getStrength(){
        return this.strength;
    }

    public int worker_value(){
        int result = Math.round(this.strength/super.getAge());
        return super.worker_value() * result;        
    }
}
