public class OfficeWorker extends Worker {

    private int iq;
    private String stationID;

    OfficeWorker(String name, String surname, int age, int experience, Address address, int iq2, String stationID2){
        super(name, surname, age, experience, address);
        this.iq = iq2;
        this.stationID = stationID2;
    }

    public void setIQ(int iq2){
        this.iq = iq2;
    }

    public int getIQ(){
        return this.iq;
    }

    public void setStationID(String id){
        this.stationID = id;
    }

    public String getStationID(){
        return this.stationID;
    }

    public int worker_value(){
        return super.worker_value() * this.iq;        
    }

}
