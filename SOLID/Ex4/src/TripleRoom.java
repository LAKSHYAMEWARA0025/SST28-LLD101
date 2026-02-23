public class TripleRoom implements RoomType {
    public Money basePrice(){
        return new Money(12000.0);
    }
    public String name(){
        return "TRIPLE";
    }
}
