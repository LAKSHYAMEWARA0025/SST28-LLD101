package APIRateLimiter;

public class Main {
    public static void main(String[] args){
        Client c1=new Client(0,"123");
        Client c2=new Client(2,"123");
        Client c4=new Client(3,"123");
        Client c5=new Client(3,"123");
        Client c3=new Client(6,"123");
        ILimitStrategy strategy=new movingWindowStrategy();
        RateLimiterProxy rp=new RateLimiterProxy(strategy);
        rp.generate(c1);
        rp.generate(c2);
        rp.generate(c4);
        rp.generate(c5);
        rp.generate(c3);
    }
}
