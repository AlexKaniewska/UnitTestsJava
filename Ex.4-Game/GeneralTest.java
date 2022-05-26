import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class GeneralTest {
    @Test
    public void test_init(){
        General g1 = new General("general1");
        assertEquals("general1", g1.getName());
        assertEquals(1000.0, g1.getMoney());
        assertEquals(0, g1.getArmy().size());
        assertEquals(0, g1.getListeners().size());
    }

    @Test
    public void test_add_listener(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s = new Secretary(g1, g2);

        g1.add(s);
        assertEquals(1, g1.getListeners().size());
        assertEquals(s, g1.getListeners().get(0));
    }

    @Test
    public void test_delete_listener(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s1 = new Secretary(g1, g2);
        Secretary s2 = new Secretary(g1, g2);
        g1.add(s1);
        g1.add(s2);
        g1.delete(s1);
        assertEquals(1, g1.getListeners().size());
        assertEquals(s2, g1.getListeners().get(0));
    }

    @Test
    public void test_maneuver(){
        General g1 = new General("general1");
        Rank r1 = new Rank("Kapral");
        g1.buy_soldier(r1);

        g1.army_maneuver_all();
        assertEquals(2, g1.getArmy().get(0).getExperience());       
    }

    @ Test
    public void test_buy_soldier(){
        General g1 = new General("general1");
        Rank r1 = new Rank("Kapral");
        g1.buy_soldier(r1);

        assertEquals(1, g1.getArmy().size());
    }

    @Test
    public void test_kill_soldier(){
        General g1 = new General("general1");
        Rank r1 = new Rank("Kapral");
        g1.buy_soldier(r1);
        g1.kill_soldier(0);
        assertEquals(0, g1.getArmy().size());
    }

    @Test
    public void test_attack(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Rank r1 = new Rank("Szeregowy");
        Rank r2 = new Rank("Major");
        g1.buy_soldier(r1);
        g1.army_maneuver_all();
        g2.buy_soldier(r2);

        g1.attack(g2);
        assertEquals(890.1, g1.getMoney());
        assertEquals(1058.9, g2.getMoney());
    }

    @Test
    public void test_attack_draw(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Rank r1 = new Rank("Szeregowy");
        Rank r2 = new Rank("Major");
        g1.buy_soldier(r1);
        g1.buy_soldier(r2);
        g1.army_maneuver_all();
        g2.buy_soldier(r1);
        g2.buy_soldier(r2);
        g2.army_maneuver_all();

        g1.attack(g2);
        assertEquals(945.0, g1.getMoney());
        assertEquals(945.0, g2.getMoney());
    }

    @Test
    public void test_attack_draw_size(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Rank r1 = new Rank("Szeregowy");
        Rank r2 = new Rank("Major");
        g1.buy_soldier(r1);
        g1.buy_soldier(r2);
        g1.army_maneuver_all();
        g2.buy_soldier(r1);
        g2.buy_soldier(r2);
        g2.army_maneuver_all();

        g1.attack(g2);
        assertEquals(1, g1.getArmy().size());
        assertEquals(1, g2.getArmy().size());
    }

    @Test
    public void test_file(){
        General g1 = new General("general1");
        g1.saveStatus();
        assertEquals("General: " + "general1" + "  Army: " + "[]" + "  Money: " + "1000.0" + "  Listeners: " + "[]", g1.getStatus());
    }
}
