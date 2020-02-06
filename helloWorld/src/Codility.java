import java.util.HashMap;
import java.util.Map;

public class Codility {
    public static void main(String[] args) {
        Codility codility = new Codility();
        int A[]={2,-2,-3,3};
        int B[]={0,0,4,-4};
      //  System.out.println(codility.solution(A,B));
    }

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A, int[] B) {
            int result=0;
            Map<Integer,Integer> mapB = new HashMap<>();
            int sumA = sum(A);
            int sumB = sum(B);
            int sumBsofar = 0;
            for(int i=0;i<B.length-1;i++){
                sumBsofar = sumBsofar+B[i];
                if(sumBsofar == sumB-sumBsofar){
                    mapB.put(i,sumBsofar);
                }
            }
            int sumAsofar = 0;
            for(int i=0;i< A.length-1;i++){
                sumAsofar = sumAsofar+A[i];
                if(sumAsofar == sumA-sumAsofar){
                    if(mapB.containsKey(i)){
                        if(mapB.get(i)==sumAsofar){
                            result++;
                        }
                    }
                }
            }
            return result;
            // write your code in Java SE 8
        }
        int sum(int in[]){
            int summ = 0;
            for(int i=0;i<in.length;i++){
                summ = summ + in[i];
            }
            return summ;
        }
    }

}
