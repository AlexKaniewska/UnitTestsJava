import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class OfficeWorkerTest {
    
    @Test
    public void test_name(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals("AK", w1.getName());
    }

    @Test
    public void test_surname(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals("Surname", w1.getSurname());
    }

    @Test
    public void test_age(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals(21, w1.getAge());
    }

    @Test
    public void test_exp(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals(2, w1.getExp());
    }

    @Test
    public void test_address(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals(a1, w1.getAddress());
    }

    @Test
    public void test_iq(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals(99, w1.getIQ());
    }

    @Test
    public void test_stationID(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        assertEquals("A2", w1.getStationID());
    }

    @Test
    public void test_value(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        int value = w1.worker_value();
        assertEquals(198, value);
    }

}
