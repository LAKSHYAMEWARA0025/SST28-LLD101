public class DefaultRoom implements RoomType{
    public Money basePrice(){
        return new Money(16000.0);
    }
    public String name(){
        return "DEFAULT";
    }
}
