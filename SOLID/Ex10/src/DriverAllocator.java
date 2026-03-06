public class DriverAllocator implements DriverAllocate {
    public String allocate(String studentId) {
        // fake deterministic driver
        return "DRV-17";
    }
}
