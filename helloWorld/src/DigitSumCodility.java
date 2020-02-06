public class DigitSumCodility {
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int N) {
            int k = sum(N);
            // write your code in Java SE 8
            for(int i = N+1; i< 50000; i++){
                if(k==sum(i)){
                    return i;
                }
            }
            return -1;

        }
        public int sum(int n){
            int sum=0;
            while(n>0){
                int k = n%10;
                sum = sum +k;
                n=n/10;
            }
            return sum;
        }

    }

}
