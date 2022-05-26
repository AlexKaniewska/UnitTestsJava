import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class SoldierTest {
    @Test
    public void test_init(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);

        assertEquals(2, r.getNumber());
        assertEquals(1, s.getExperience());
        assertEquals(2, s.getPower());
    }

    @Test
    public void test_addExp1(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.addExperience();
        assertEquals(2, s.getExperience());
    }

    @Test
    public void test_addExp2(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.addExperience();
        assertEquals(4, s.getPower());
    }

    @Test
    public void test_add5(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.setExperience(10);
        s.addExperience();
        assertEquals(3, s.getRank().getNumber());
    }

    @Test
    public void test_add5_exp(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.setExperience(9);
        s.addExperience();
        assertEquals(1, s.getExperience());
    }

    @Test
    public void test_minExp1(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.setExperience(3);
        s.minusExperience();
        assertEquals(2, s.getExperience());
    }

    @Test
    public void test_minExp2(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.setExperience(3);
        s.minusExperience();
        assertEquals(4, s.getPower());
    }

    @Test
    public void test_power(){
        Rank r = new Rank("Kapral");
        Soldier s = new Soldier(r);
        s.setExperience(4);
        assertEquals(8, s.getPower());
    }
}
