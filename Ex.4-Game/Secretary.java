import java.util.*;

public class Secretary implements Listener {
    private General general1;
    private General general2;
    private ArrayList<Report> report;

    public Secretary(General g1, General g2){
        this.general1 = g1;
        this.general2 = g2;
        this.report = new ArrayList<Report>();
    }

    public void setGeneral1(General g1){
        this.general1 = g1;
    }

    public General getGeneral1(){
        return this.general1;
    }

    public void setGeneral2(General g2){
        this.general2 = g2;
    }

    public General getGeneral2(){
        return this.general2;
    }

    public void setReport(ArrayList<Report> data){
        this.report = data;
    }

    public ArrayList<Report> getReport(){
        return this.report;
    }

    @Override
    public void addAction(Report data){
        this.report.add(data);
    }
}
