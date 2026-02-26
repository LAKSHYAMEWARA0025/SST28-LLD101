public class StaffDiscountPolicy implements DiscountPolicy{
    public double discount(double subtotal,int distinctLines){
         if (distinctLines >= 3) return 15.0;
            return 5.0;
    }
}
