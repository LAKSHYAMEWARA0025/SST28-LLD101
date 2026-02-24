public class FixedDepositPolicy implements DepositPolicy{
    public Money deposit(){
        return new Money(5000.0);
    }
}
