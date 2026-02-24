public interface BookingRepository {
    public void save(String bookingId,
              BookingRequest req,
              Money monthly,
              Money deposit);
}
