package APIRateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class fixedWindowStrategy implements ILimitStrategy {
    //let's say timeframe given is of 4 second and req acceptable is 3.
    private int currtime=0;
    private int endtime=3;
    private int finalcount=3;
    private Queue<Client> q=new LinkedList<>();
    public boolean allowRequest(Client c){
        int time=c.time;
        if(time>=currtime && time<=endtime && q.size()<finalcount){
            q.add(c);
            System.out.println("API request accepted! at time "+time);
            return true;
        }else if(time>=currtime && time<=endtime && q.size()>=finalcount){
            System.out.println("Rate limit exceeded for given time limit "+time);
            return false;
        }else if(time>endtime){
            System.out.println("API request accepted in new time frame-> time: "+time);
            currtime=time;
            endtime+=time;
            while(!q.isEmpty()) q.poll();
            return true;
        }
        return false;
    }
}
