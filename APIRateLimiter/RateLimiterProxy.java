package APIRateLimiter;
public class RateLimiterProxy {
    private RemoteResource rr;
    private ILimitStrategy strategy;

    public RateLimiterProxy(ILimitStrategy strategy){
        this.strategy=strategy;
        this.rr=new RemoteResource();
    }
    public void generate(Client client){
        if(strategy.allowRequest(client)){
            rr.generate(client.clientId);
        }
        else{
            System.out.println("Sorry API Rate Limit is exceeded!");
        }
    }
}
