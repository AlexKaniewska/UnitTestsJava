import java.util.*;

public class Worker {
    private long id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private Address address;


    public Worker(String name2, String sur2, int age2, int exp, Address ad){
        this.id = (new Date().getTime());
        this.name = name2;
        this.surname = sur2;
        this.age = age2;
        this.experience = exp;
        this.address = ad;
    }

    public void setID(long id2){
        this.id = id2;
    }
    
    public long getID(){
        return this.id;
    }

    public void setName(String name2){
        this.name = name2;
    }

    public String getName(){
        return this.name;
    }

    public void setSurname(String surname2){
        this.surname = surname2;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setage(int age2){
        this.age = age2;
    }

    public int getAge(){
        return this.age;
    }

    public void setExp(int exp){
        this.experience = exp;
    }

    public int getExp(){
        return this.experience;
    }

    public void setAddress(Address adr){
        this.address = adr;
    }

    public Address getAddress(){
        return this.address;
    }

    public int worker_value(){
        return this.experience;
    }
}
