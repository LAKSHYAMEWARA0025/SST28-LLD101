public class DiscountRules {
    public DiscountPolicy discountAmount(String customerType) {
        // hard-coded policy (smell)
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentDiscountPolicy();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            // if (distinctLines >= 3) return 15.0;
            // return 5.0;
            return new StaffDiscountPolicy();
        }
        return new DefaultDiscountPolicy();
    }
}
