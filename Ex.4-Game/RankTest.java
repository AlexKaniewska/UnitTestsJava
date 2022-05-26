import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RankTest {
   
    @Test
    public void test_1(){
        Rank rank = new Rank("Szeregowy");
        assertEquals(1, rank.getNumber());
    }

    @Test
    public void test_2(){
        Rank rank = new Rank("Kapral");
        assertEquals(2, rank.getNumber());
    }

    @Test
    public void test_3(){
        Rank rank = new Rank("Kapitan");
        assertEquals(3, rank.getNumber());
    }

    @Test
    public void test_4(){
        Rank rank = new Rank("Major");
        assertEquals(4, rank.getNumber());
    }
}
