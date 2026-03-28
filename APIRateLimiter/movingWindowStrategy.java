package APIRateLimiter;
import java.util.*;


public class movingWindowStrategy implements ILimitStrategy {
    private int windowSize=4;
    private int maxRequests=3;
    private Map<String, Queue<Integer>> map=new HashMap<>();
    public boolean allowRequest(Client c){
        String clientId=c.clientId;
        int time=c.time;
        map.putIfAbsent(clientId, new LinkedList<>());
        Queue<Integer> q=map.get(clientId);
        //remove expired requests
        while(!q.isEmpty() && q.peek()<= time-windowSize){
            q.poll();
        }
        if(q.size()<maxRequests){
            q.add(time);
            System.out.println("Request accepted at time "+time);
            return true;
        }
        System.out.println("Rate limit exceeded at time "+ time);
        return false;
    }
}
