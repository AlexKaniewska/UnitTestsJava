import org.junit.Test;
import java.time.*;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*; 

public class BankTests {

    //Deposit Test
    @Test
    public void testClientInit() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");

        assertEquals(0, sut.getBalance());
        assertEquals("AK", sut.getName());
        assertTrue(sut.getHistory().isEmpty());
    }

    @Test
    public void testDeposit200() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.deposit(200);
        assertEquals("0+200 = 200",200, sut.getBalance());
    }

    @Test (expected = Bank.Client.Error.class)
    public void testDepositMinus() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.deposit(-200);
    }

    @Test (expected = Bank.Client.Error.class)
    public void testDepositZero() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.deposit(0);
    }

    @Test
    public void testDepositHistory() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.deposit(200);
        String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        assertEquals("Deposit", sut.getHistory().get(0).getTitle());
        assertEquals(200, sut.getHistory().get(0).getValue());
        assertEquals(operation_data, sut.getHistory().get(0).getDate());
    }

    //Withdrawal Test
    @Test
    public void testWithdrawalt50() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.setBalance(200);
        sut.withdrawal(50);
        assertEquals(150, sut.getBalance());
    }

    @Test (expected = Bank.Client.Error.class)
    public void testWithdrawaltMore() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.setBalance(200);
        sut.withdrawal(250);
    }

    @Test (expected = Bank.Client.Error.class)
    public void testWithdrawaltMinus() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.setBalance(200);
        sut.withdrawal(-50);
    }

    @Test (expected = Bank.Client.Error.class)
    public void testWithdrawaltZero() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.setBalance(200);
        sut.withdrawal(0);
    }

    @Test
    public void testWithdrawalHistory() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        sut.setBalance(200);
        sut.withdrawal(150);
        String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        assertEquals("Withdrawal", sut.getHistory().get(0).getTitle());
        assertEquals(150, sut.getHistory().get(0).getValue());
        assertEquals(operation_data, sut.getHistory().get(0).getDate());
    }

    //Bank Transfer
    @Test
    public void testBankTransferCorrect() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client sut2 = new Bank.Client("SK");
        sut.setBalance(200);
        sut.bank_transfer(100, sut2);
        assertEquals(100, sut.getBalance());
        assertEquals(100, sut2.getBalance());
    }

    @Test (expected = Bank.Client.Error.class)
    public void testBankTransferMore() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client sut2 = new Bank.Client("SK");
        sut.setBalance(200);
        sut.bank_transfer(250, sut2);
    }

    @Test
    public void testBankTransferlHistory1() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client sut2 = new Bank.Client("SK");
        sut.setBalance(200);
        sut.bank_transfer(50, sut2);
        String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        assertEquals("Transfer - from", sut.getHistory().get(0).getTitle());
        assertEquals(50, sut.getHistory().get(0).getValue());
        assertEquals(operation_data, sut.getHistory().get(0).getDate());
    }

    @Test
    public void testBankTransferlHistory2() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client sut2 = new Bank.Client("SK");
        sut.setBalance(200);
        sut.bank_transfer(50, sut2);
        String operation_data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
 
        assertEquals("Transfer - to", sut2.getHistory().get(0).getTitle());
        assertEquals(50, sut2.getHistory().get(0).getValue());
        assertEquals(operation_data, sut2.getHistory().get(0).getDate());
    }

    //History
    @Test
    public void testHistoryTime() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client.Operation sut2 = new Bank.Client.Operation("Title", 500, "2021-01-01");
        Bank.Client.Operation sut3 = new Bank.Client.Operation("Title", 500, "2021-02-01");
        Bank.Client.Operation sut4 = new Bank.Client.Operation("Title", 500, "2021-03-01");
        ArrayList<Bank.Client.Operation> new_list = new ArrayList<>();
        new_list.add(sut2);
        new_list.add(sut3);
        new_list.add(sut4);
        sut.setHistory(new_list);

        assertEquals(2, sut.history(LocalDate.parse("2021-01-01"), LocalDate.parse("2021-04-01")).size());
    }

    @Test
    public void testHistoryTime2() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        Bank.Client.Operation sut2 = new Bank.Client.Operation("Title", 500, "2021-01-01");
        Bank.Client.Operation sut3 = new Bank.Client.Operation("Title", 500, "2021-02-01");
        Bank.Client.Operation sut4 = new Bank.Client.Operation("Title", 500, "2021-03-01");
        ArrayList<Bank.Client.Operation> new_list = new ArrayList<>();
        new_list.add(sut2);
        new_list.add(sut3);
        new_list.add(sut4);
        sut.setHistory(new_list);
        
        assertEquals("2021-02-01", sut.history(LocalDate.parse("2021-01-01"), LocalDate.parse("2021-04-01")).get(0).getDate());
        assertEquals("2021-03-01", sut.history(LocalDate.parse("2021-01-01"), LocalDate.parse("2021-04-01")).get(1).getDate());
    }

    @Test (expected = Bank.Client.Error.class)
    public void testHistoryError() throws Bank.Client.Error{
        Bank.Client sut = new Bank.Client("AK");
        
        sut.history(LocalDate.parse("2021-04-01"), LocalDate.parse("2021-02-01"));
    }

}
