public class Rank {
    private String title;
    private int number;

    public Rank(String rank){
        this.title = rank;
        if(rank == "Szeregowy"){
            this.number = 1;
        }
        else if(rank == "Kapral"){
            this.number = 2;
        }
        else if(rank == "Kapitan"){
            this.number = 3;
        }
        else if(rank == "Major"){
            this.number = 4;
        }
    }

    public String getTitle(){
        return title;
    }

    public int getNumber(){
        return number;
    }
}