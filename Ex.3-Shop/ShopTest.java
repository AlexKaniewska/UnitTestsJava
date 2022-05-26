import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*; 

public class ShopTest {
    @Test
    public void testProductInit(){
        Product sut = new Product("code", "name", 5.0);

        assertEquals(Double.valueOf(5.0), sut.getPrice());
        assertEquals(Double.valueOf(5.0*0.95), sut.getDiscount());
        assertEquals("code", sut.getCode());
        assertEquals("name", sut.getName());
    }

    @Test
    public void testCartInit(){
        ShoppingCart sut = new ShoppingCart();

        assertEquals(0, sut.getCart().size());
        assertEquals(Double.valueOf(0.0), sut.getBalance());
    }

    @Test
    public void testAddOneProduct(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "name", 5.0);

        sut.addProduct(sut2, prod1);

        assertEquals(1, sut2.getCart().size());
        assertEquals(Double.valueOf(5.0), sut2.getBalance());
    }

    @Test
    public void testAddThreeProduct(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "name", 5.0);
        Product prod2 = new Product("code2", "name2", 8.0);
        Product prod3 = new Product("code3", "name3", 7.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);

        assertEquals(3, sut2.getCart().size());
        assertEquals(Double.valueOf(8.0), sut2.getCart().get(0).getPrice());
    }

    @Test
    public void testAddProductsSort(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);
        Product prod3 = new Product("code3", "c", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);
        
        assertEquals(3, sut2.getCart().size());
        assertEquals("b", sut2.getCart().get(0).getName());
    }

    @Test
    public void testIfPrint(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);
        Product prod3 = new Product("code3", "c", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);
        
        sut.printCart(sut2);
    }

    @Test
    public void testGetOneMin(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        ArrayList <String> expected = new ArrayList<>();
        expected.add("Name: " + "a" + "  Price: " + "5.0");

        assertEquals(expected, sut.getMinimum(sut2, 1));
    }

    @Test
    public void testGetTwoMin(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);
        Product prod3 = new Product("code3", "c", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);

        ArrayList <String> expected = new ArrayList<>();
        expected.add("Name: " + "a" + "  Price: " + "5.0");
        expected.add("Name: " + "c" + "  Price: " + "8.0");

        assertEquals(expected, sut.getMinimum(sut2, 2));
    }

    @Test
    public void testGetOneMax(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        ArrayList <String> expected = new ArrayList<>();
        expected.add("Name: " + "b" + "  Price: " + "8.0");

        assertEquals(expected, sut.getMaximum(sut2, 1));
    }

    @Test
    public void testGetTwoMax(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 10.0);
        Product prod3 = new Product("code3", "c", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);

        ArrayList <String> expected = new ArrayList<>();
        expected.add("Name: " + "b" + "  Price: " + "10.0");
        expected.add("Name: " + "c" + "  Price: " + "8.0");

        assertEquals(expected, sut.getMaximum(sut2, 2));
    }

    @Test
    public void testSortByName(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "x", 5.0);
        Product prod2 = new Product("code2", "b", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        ArrayList <Product> expected = new ArrayList<>();
        expected.add(prod2);
        expected.add(prod1);

        sut.sortByName(sut2);

        assertEquals(expected, sut2.getCart());
    }

    @Test
    public void testSortByPrice(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "x", 24.99);
        Product prod2 = new Product("code2", "b", 2.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        ArrayList <Product> expected = new ArrayList<>();
        expected.add(prod2);
        expected.add(prod1);

        sut.sortByPrice(sut2);

        assertEquals(expected, sut2.getCart());
    }

    @Test
    public void TestSumOfCart(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 5.0);
        Product prod2 = new Product("code2", "b", 10.0);
        Product prod3 = new Product("code3", "c", 8.0);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);

        assertEquals(Double.valueOf(23.0), sut.sumOfCart(sut2));
    }

    @Test
    public void TestBuy200(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 59.99);
        Product prod2 = new Product("code2", "b", 163.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        assertEquals(2, sut2.getCart().size());
        sut.buy(sut2, 1, false);
        assertEquals(3, sut2.getCart().size());
    }

    @Test
    public void TestBuy3Products(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 59.99);
        Product prod2 = new Product("code2", "b", 63.99);
        Product prod3 = new Product("code3", "c", 18.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);

        assertEquals(Double.valueOf(142.97), sut2.getBalance());
        sut.buy(sut2, 1, false);
        assertEquals(Double.valueOf(123.98), sut2.getBalance());
    }

    @Test
    public void TestBuy300(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 159.99);
        Product prod2 = new Product("code2", "b", 163.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        sut.buy(sut2, 1, false);
        assertEquals(Double.valueOf(307.781), sut2.getBalance());
    }

    @Test
    public void TestBuyTrue(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 59.99);
        Product prod2 = new Product("code2", "b", 63.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);

        sut.buy(sut2, 1, true);
        assertEquals(Double.valueOf(105.983), sut2.getBalance());
    }

    @Test
    public void TestBuyAll(){
        Shop sut = new Shop();
        ShoppingCart sut2 = new ShoppingCart();

        Product prod1 = new Product("code", "a", 159.99);
        Product prod2 = new Product("code2", "b", 163.99);
        Product prod3 = new Product("code3", "c", 18.99);

        sut.addProduct(sut2, prod1);
        sut.addProduct(sut2, prod2);
        sut.addProduct(sut2, prod3);
        System.out.println(sut.sumOfCart(sut2));
        sut.buy(sut2, 1, false);
        assertEquals(Double.valueOf(306.8315), sut2.getBalance());
    }
}
