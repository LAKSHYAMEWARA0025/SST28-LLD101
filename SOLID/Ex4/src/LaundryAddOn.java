public class LaundryAddOn implements AddOns{
    public Money cost(){
        return new Money(500.0);
    }
    public String name(){
        return "LAUNDY";
    }
}
