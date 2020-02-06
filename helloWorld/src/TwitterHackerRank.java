import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TwitterHackerRank {
    public static void main(String[] args) {
        TwitterHackerRank twitterHackerRank = new TwitterHackerRank();

    }
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        Map<Integer,Integer> map = new HashMap<>();
        int time=0,count=0;
        for (List<Integer>  command : commands){
            int commandId = command.get(0);
            int tokenId = command.get(1);
            time = command.get(2);
            if(commandId==0) {
                map.put(tokenId,time+expiryLimit);
            }else{
                if(map.containsKey(tokenId)) {
                    int exp= map.get(tokenId);
                    if(exp>=time){
                        map.put(tokenId,time+expiryLimit);
                    }
                }
            }

        }
        for(int i: map.keySet()){
            if(map.get(i)> time){
                count++;
            }
        }
        return count;


    }}
