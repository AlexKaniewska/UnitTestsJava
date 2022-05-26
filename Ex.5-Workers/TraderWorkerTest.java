import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class TraderWorkerTest {
    
    @Test
    public void test_name(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals("AK", w1.getName());
    }

    @Test
    public void test_surname(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals("Surname", w1.getSurname());
    }

    @Test
    public void test_age(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals(21, w1.getAge());
    }

    @Test
    public void test_exp(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals(2, w1.getExp());
    }

    @Test
    public void test_address(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals(a1, w1.getAddress());
    }

    @Test
    public void test_efficiency(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals("LOW", w1.getEfficiency());
    }

    @Test
    public void test_commission(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        assertEquals(21, w1.getCommission());
    }

    @Test
    public void test_value_low(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "LOW", 21);
        int value = w1.worker_value();
        assertEquals(120, value);
    }

    @Test
    public void test_value_medium(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "MEDIUM", 21);
        int value = w1.worker_value();
        assertEquals(180, value);
    }

    @Test
    public void test_value_high(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("AK", "Surname", 21, 2, a1, "HIGH", 21);
        int value = w1.worker_value();
        assertEquals(240, value);
    }
}
