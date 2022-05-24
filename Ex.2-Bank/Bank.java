import java.util.*; 
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Bank {


    //klient
    public static class Client{

        Date currentDate = new Date();

        private long clientID = currentDate.getTime();
        private final String clientName;
        private int clientBalance = 0;
        private ArrayList<Operation> clientHistory = new ArrayList<>();


        public Client(String name){clientName = name;}

        public long getId(){ 
            return clientID;
        }
        public int getBalance(){ 
            return clientBalance;
        }
        public String getName(){ 
            return clientName;
        }
        public ArrayList<Operation> getHistory(){
            return clientHistory;
        }

        public void setBalance(int money){
            this.clientBalance = money;
        }
        public void setHistory(ArrayList<Operation> list){
            clientHistory = list;
        }

        public static final class Error extends Throwable{
            public Error(String error){super(error);}
        }
    


    //operacje
    public static class Operation{
        private final String title;
        private final int value;
        private String operationDate;

        public Operation(String title2, int value2, String Date){
            title = title2;
            value = value2;
            operationDate = Date;
        }

        public String getTitle(){
            return title;
        }
        public int getValue(){
            return value;
        }
        public String getDate(){
            return operationDate;
        }

    }

    

    //wpłata
    public void deposit(int money) throws Error {
        if(money > 0){

            clientBalance += money;

            String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Operation new_operation = new Operation("Deposit", money, operation_data);

            clientHistory.add(new_operation);
        }
        else {
            throw new Error("Error! You can only deposit an amount greater than zero.");
        }
    }


    //wypłata
    public void withdrawal(int money) throws Error {
        if (money <= clientBalance && money > 0){

            clientBalance -= money;

            String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Operation new_operation = new Operation("Withdrawal", money, operation_data);

            clientHistory.add(new_operation);
        }
        else {
            throw new Error("Error! You can only withdraw an amount greater than zero and less than your balance.");
        }
    }


    // przelew pomiędzy kontami
    public void bank_transfer(int money, Bank.Client client2) throws Error{
        if (money <= clientBalance && money > 0){

            clientBalance -= money;
            client2.clientBalance += money;

            String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Operation new_operation = new Operation("Transfer - from", money, operation_data);
            Operation new_operation2 = new Operation("Transfer - to", money, operation_data);

            clientHistory.add(new_operation);
            client2.clientHistory.add(new_operation2);
        }
        else {
            throw new Error("Error! You can only transfer an amount greater than zero and less than your balance.");
        }
    }


    //historia konta w podanym przedziale
    public ArrayList<Operation> history(LocalDate from, LocalDate to) throws Error{

        if (from.isBefore(to)){

            ArrayList<Operation> time_history = new ArrayList<>();

            for (Bank.Client.Operation transaction : clientHistory){
                if (LocalDate.parse(transaction.operationDate).isBefore(to) && LocalDate.parse(transaction.operationDate).isAfter(from)){
                    time_history.add(transaction);
                }       
            }

            return time_history;
        }
        else {
            throw new Error("Error!");
        }
    }
    

    }
}