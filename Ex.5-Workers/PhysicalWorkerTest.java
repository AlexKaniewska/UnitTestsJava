import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class PhysicalWorkerTest {
    
    @Test
    public void test_name(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals("AK", w1.getName());
    }

    @Test
    public void test_surname(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals("Surname", w1.getSurname());
    }

    @Test
    public void test_age(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals(21, w1.getAge());
    }

    @Test
    public void test_exp(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals(2, w1.getExp());
    }

    @Test
    public void test_address(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals(a1, w1.getAddress());
    }

    @Test
    public void test_strength(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        assertEquals(80, w1.getStrength());
    }

    @Test
    public void test_value(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        PhysicalWorker w1 = new PhysicalWorker("AK", "Surname", 21, 2, a1, 80);
        int value = w1.worker_value();
        assertEquals(6, value);
    }
}
