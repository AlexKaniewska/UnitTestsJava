import java.util.*;

public class Shop {

    //dodnie produktu do koszyka
    public void addProduct(ShoppingCart cart, Product item){
        
        cart.cartBalance += item.getPrice();
        cart.myCart.add(item);
        
        cart.myCart.sort(Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getName));
    }

    //get minimum n produtow
    public ArrayList<String> getMinimum(ShoppingCart cart, int amount){

        cart.myCart.sort(Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getName));
        ArrayList<String> min_products = new ArrayList<>();

            for(int i=0; i < amount; i++){
                min_products.add("Name: " + cart.myCart.get(cart.myCart.size() - 1 - i).getName() + "  Price: " + cart.myCart.get(cart.myCart.size() - 1 - i).getPrice());
            }

            return min_products;
            
    }

    //get maximum n produktow
    public ArrayList<String> getMaximum(ShoppingCart cart, int amount){

        cart.myCart.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getName));
    
        ArrayList<String> max_products = new ArrayList<>();

            for(int i=0; i < amount; i++){
                max_products.add("Name: " + cart.myCart.get(cart.myCart.size() - 1 - i).getName() + "  Price: " + cart.myCart.get(cart.myCart.size() - 1 - i).getPrice());
            }

            return max_products;
    }

    //sort po nazwie
    public void sortByName(ShoppingCart cart){
        
        cart.myCart.sort(Comparator.comparing(Product::getName));
    }

    //sort po cenie
    public void sortByPrice(ShoppingCart cart){
        
        cart.myCart.sort(Comparator.comparing(Product::getPrice));   
    }

    //pokaz sume
    public Double sumOfCart(ShoppingCart cart){
        
        return cart.cartBalance;   
    }

    //wyswietlanie koszyka w konsoli
    public void printCart(ShoppingCart cart){
        
        for (Product sth : cart.myCart){
            System.out.println("Name: " + sth.getName() + "  Code: " + sth.getCode() + "  Price: " + sth.getPrice() + "  Discount price: " + sth.getDiscount());
        }    
    }

    //kup == oblicz odpowiednie promocje
    public Double buy(ShoppingCart cart, int index, boolean first){
        cart.myCart.sort(Comparator.comparing(Product::getPrice).reversed());

        Discount myDiscount = new Discount(cart,first, index);
        ShoppingCart result = myDiscount.getDiscount();
        return result.cartBalance;
    }
        
}
