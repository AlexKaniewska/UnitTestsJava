import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import java.util.*;

public class RegistryTest {
    
    @Test
    public void test_init(){
        Registry r1 = new Registry();
        assertEquals(new ArrayList<Worker>(), r1.getList());
    }

    @Test
    public void test_add_one(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        Registry r1 = new Registry();
        r1.addWorkers(w1);
        assertEquals(1, r1.getList().size());
    }

    @Test
    public void test_add_few(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        TraderWorker w1 = new TraderWorker("Name", "surname", 21, 5, a1, "MEDIUM", 60);
        OfficeWorker w2 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        Registry r1 = new Registry();
        r1.addWorkers(w1, w2);
        assertEquals(2, r1.getList().size());
    }

    @Test
    public void test_delete(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        TraderWorker w2 = new TraderWorker("Name", "surname", 21, 5, a1, "MEDIUM", 60);
        Registry r1 = new Registry();
        r1.addWorkers(w1, w2);
        r1.deleteWorker(w1.getID());
        assertEquals(1, r1.getList().size());
    }

    @Test
    public void test_city(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Address a2 = new Address("ul. Java", "2H/", "77", "Sopot");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        TraderWorker w2 = new TraderWorker("Name", "surname", 21, 5, a2, "MEDIUM", 60);
        Registry r1 = new Registry();
        r1.addWorkers(w1, w2);
        
        assertEquals(1, r1.showWorkersCity2("Gdynia").size());
    }

    @Test
    public void test_value(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Address a2 = new Address("ul. Java", "2H/", "77", "Sopot");
        OfficeWorker w1 = new OfficeWorker("AK", "Surname", 21, 2, a1, 99, "A2");
        TraderWorker w2 = new TraderWorker("Name", "surname", 21, 5, a2, "MEDIUM", 60);
        Registry r1 = new Registry();
        r1.addWorkers(w1, w2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(198);
        list.add(450);
        assertEquals(list, r1.showWorkersValue2());
    }

    @Test
    public void test_print(){
        Address a1 = new Address("ul. Java", "2H/", "77", "Gdynia");
        Address a2 = new Address("ul. Java", "2H/", "77", "Sopot");
        OfficeWorker w1 = new OfficeWorker("AK", "Abc", 21, 5, a1, 99, "A2");
        TraderWorker w2 = new TraderWorker("Name", "Def", 21, 5, a2, "MEDIUM", 60);
        Registry r1 = new Registry();
        r1.addWorkers(w1, w2);
        r1.showWorkersSort();
    }


}
