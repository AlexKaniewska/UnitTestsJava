public class Address {
    private String street;
    private String house_nr;
    private String local_nr;
    private String city;

    public Address(String street2, String nr, String nr2, String city2){
        this.street = street2;
        this.house_nr = nr;
        this.local_nr = nr2;
        this.city = city2;
    }

    public void setStreet(String street2){
        this.street = street2;
    }

    public String getStreet(){
        return this.street;
    }

    public void setHouseNr(String nr){
        this.house_nr = nr;
    }

    public String getHouseNr(){
        return this.house_nr;
    }

    public void setLocalNr(String nr){
        this.local_nr = nr;
    }

    public String getLocalNr(){
        return this.local_nr;
    }

    public void setCity(String city2){
        this.city = city2;
    }

    public String getCity(){
        return this.city;
    }

}
