public class Discount {

    private final ShoppingCart buyCart;
    private final boolean first;
    private final int index;

    public Discount(ShoppingCart cart2, boolean disc2, int index2){
        buyCart = cart2;
        first = disc2;
        index = index2;
    }


    public ShoppingCart getDiscount(){
        check300();
        check2Products();
        check200();
        checkFirstDiscount();

        return buyCart;
           
    }

    public ShoppingCart check300(){
        if (buyCart.cartBalance > 300.0){
            buyCart.cartBalance = buyCart.cartBalance*0.95;
        }
        return buyCart;
    }

    public ShoppingCart check2Products(){
        if (buyCart.myCart.size() == 3) {
            buyCart.cartBalance = buyCart.cartBalance - buyCart.myCart.get(buyCart.myCart.size() -1).getPrice();
        }         
        return buyCart;
    }

    public ShoppingCart check200(){
        if (buyCart.cartBalance > 200.0){
            Product kubek = new Product("000", "kubek firmowy", 0.0);
            buyCart.myCart.add(kubek);          
        }
        return buyCart;
    }

    public ShoppingCart checkFirstDiscount(){
        if (first == true){
            if (index < buyCart.myCart.size()){
                buyCart.cartBalance = buyCart.cartBalance - (buyCart.myCart.get(index).getPrice()*0.3);
            }
        }
        return buyCart;
    }
}
