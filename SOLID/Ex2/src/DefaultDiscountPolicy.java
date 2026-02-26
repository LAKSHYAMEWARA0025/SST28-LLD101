public class DefaultDiscountPolicy implements DiscountPolicy{
    public double discount(double subtotal,int distinctLines){
        return 0.0;
    }
}
