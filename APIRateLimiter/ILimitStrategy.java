package APIRateLimiter;
public interface ILimitStrategy {
    public boolean allowRequest(Client client);
}
