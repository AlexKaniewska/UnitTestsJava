import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import java.util.*;

public class ReportTest {
	@Test
	public void test_init() {
		Report tool = new Report("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_kill() {
		Report tool = new Kill("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_kill_message() {
		Report tool = new Kill("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "killed soldier" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_buy() {
		Report tool = new Buy("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_buy_message() {
		Report tool = new Buy("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "bought soldier" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_attack() {
		Report tool = new Attack("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_attack_message() {
		Report tool = new Attack("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "attacked" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_victory() {
		Report tool = new Victory("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_victory_message() {
		Report tool = new Victory("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "won battle" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_draw() {
		Report tool = new Draw("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_draw_message() {
		Report tool = new Draw("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "had a draw" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_maneuver() {
		Report tool = new Maneuver("general", new ArrayList<Soldier>());
		assertEquals(tool.getGeneral(), "general");
		assertEquals(tool.getMove(), "");
	}

	@Test
	public void test_maneuver_message() {
		Report tool = new Maneuver("general", new ArrayList<Soldier>());
		assertEquals("General  : " + "general" + "\n"+ "did: " + "did maneuver" + "\n"+ "with their army: " + "[]", tool.myAction() );
	}

	@Test
	public void test_promotion() {
		Report tool = new Promotion("Major", 8);
		assertEquals(tool.getGeneral(), "Major");
	}

	@Test
	public void test_promotion_message() {
		Report tool = new Promotion("Major", 8);
		assertEquals("Soldier  : " + "Major" + "\n"+ "did: " + "promoted" + "\n"+ "with their ability: " + "8", tool.myAction() );
	}

	@Test
	public void test_minexp() {
		Report tool = new MinExp("Major", 8);
		assertEquals(tool.getGeneral(), "Major");
	}

	@Test
	public void test_minexp_message() {
		Report tool = new MinExp("Major", 8);
		assertEquals("Soldier  : " + "Major" + "\n"+ "did: " + "lost experience" + "\n"+ "with their ability: " + "8", tool.myAction() );
	}

	@Test
	public void test_maxexp() {
		Report tool = new MaxExp("Major", 8);
		assertEquals(tool.getGeneral(), "Major");
	}

	@Test
	public void test_maxexp_message() {
		Report tool = new MaxExp("Major", 8);
		assertEquals("Soldier  : " + "Major" + "\n"+ "did: " + "gain experience" + "\n"+ "with their ability: " + "8", tool.myAction() );
	}
}
