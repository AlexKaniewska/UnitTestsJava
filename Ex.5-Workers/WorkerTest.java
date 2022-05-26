import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class WorkerTest {
    @Test
    public void test_name(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Surname", 22, 2, a1);
        assertEquals("Name", w1.getName());
    }

    @Test
    public void test_surname(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Surname", 22, 2, a1);
        assertEquals("Surname", w1.getSurname());
    }

    @Test
    public void test_age(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Surname", 22, 2, a1);
        assertEquals(22, w1.getAge());
    }

    @Test
    public void test_exp(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Surname", 22, 2, a1);
        assertEquals(2, w1.getExp());
    }

    @Test
    public void test_address(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Suername", 22, 2, a1);
        assertEquals(a1, w1.getAddress());
    }

    @Test
    public void test_value(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Worker w1 = new Worker("Name", "Suername", 22, 2, a1);
        int value = w1.worker_value();
        assertEquals(2, value);
    }
}
