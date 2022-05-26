public class Product {
    
    private final String code;
    private final String name;
    private final Double price;
    private final Double discountPrice;

    public Product(String code2, String name2, Double price2){
        code = code2;
        name = name2;
        price = price2;
        discountPrice = price2*0.95;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public Double getDiscount(){
        return discountPrice;
    }
    
}
