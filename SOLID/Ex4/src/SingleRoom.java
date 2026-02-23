public class SingleRoom implements RoomType{
    public Money basePrice(){
        return new Money(14000.0);
    }
    public String name(){
        return "SINGLE";
    }
}
