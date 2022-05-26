import java.util.*;

public class ShoppingCart {
    public Double cartBalance = 0.0;
    public ArrayList<Product> myCart = new ArrayList<>();

    public Double getBalance(){ 
        return cartBalance;
    }
    
    public ArrayList<Product> getCart(){
        return myCart;
    }

    public void setBalance(Double money){
        this.cartBalance = money;
    }
    public void setCart(ArrayList<Product> list){
        myCart = list;
    }
}
