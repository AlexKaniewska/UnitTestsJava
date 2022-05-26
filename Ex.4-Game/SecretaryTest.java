import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class SecretaryTest {
    @Test
    public void test_init(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s = new Secretary(g1, g2);

        g1.add(s);
        g2.add(s);

        assertEquals(1, g1.getListeners().size());
        assertEquals(1, g2.getListeners().size());
    }

    @Test
    public void test_buy(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s = new Secretary(g1, g2);
        Rank r = new Rank("Kapral");
        g1.add(s);
        g2.add(s);

        g1.buy_soldier(r);
        assertEquals(1, s.getReport().size());
    }

    @Test
    public void test_buy_message(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s = new Secretary(g1, g2);
        Rank r = new Rank("Kapral");
        g1.add(s);
        g2.add(s);

        g1.buy_soldier(r);

        assertEquals("general1", s.getReport().get(0).getGeneral());
    }

    @Test
    public void test_army(){
        General g1 = new General("general1");
        General g2 = new General("general2");
        Secretary s = new Secretary(g1, g2);
        Rank r = new Rank("Kapral");
        g1.add(s);
        g2.add(s);

        g1.buy_soldier(r);

        assertEquals(1, s.getReport().get(0).getArmy().size());
    }
}
