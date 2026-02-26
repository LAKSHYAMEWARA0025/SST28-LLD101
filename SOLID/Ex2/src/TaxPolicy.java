public interface TaxPolicy {
    public double taxPercent(String customerType);
}
//now we need to implement it differently for StudentTaxPolicy, StaffTaxPolicy......