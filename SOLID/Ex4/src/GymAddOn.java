public class GymAddOn implements AddOns{
    public Money cost(){
        return new Money(300.0);
    }
    public String name(){
        return "GYM";
    }
}
