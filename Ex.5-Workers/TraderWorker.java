public class TraderWorker extends Worker {
    private String efficiency;
    private int commission;

    TraderWorker(String name, String surname, int age, int experience, Address address, String efficiency2, int commission2){
        super( name, surname, age, experience, address);
        this.efficiency = efficiency2;
        this.commission = commission2;
    }

    public void setEfficiency(String eff){
        this.efficiency = eff;
    }

    public String getEfficiency(){
        return this.efficiency;
    }

    public void setCommission(int com){
        this.commission = com;
    }

    public int getCommission(){
        return this.commission;
    }

    public int worker_value(){
        if (this.efficiency == "LOW"){
            return super.worker_value() * 60;
        }
        else if(this.efficiency == "MEDIUM"){
            return super.worker_value() * 90;
        }
        else{
            return super.worker_value() * 120;
        }        
    }
}
