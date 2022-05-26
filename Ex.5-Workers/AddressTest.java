import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class AddressTest {
    @Test
    public void test_street(){
        Address a1 = new Address("Ul. Java", "2A/", "74", "Gdynia");
        assertEquals("Ul. Java", a1.getStreet());
    }

    @Test
    public void test_house(){
        Address a1 = new Address("Ul. Java", "2A/", "74", "Gdynia");
        assertEquals("2A/", a1.getHouseNr());
    }

    @Test
    public void test_local(){
        Address a1 = new Address("Ul. Java", "2A/", "74", "Gdynia");
        assertEquals("74", a1.getLocalNr());
    }

    @Test
    public void test_city(){
        Address a1 = new Address("Ul. Java", "2A/", "74", "Gdynia");
        assertEquals("Gdynia", a1.getCity());
    }
}