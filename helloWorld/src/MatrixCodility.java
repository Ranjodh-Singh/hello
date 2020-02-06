public class MatrixCodility {
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public String solution(int u, int l, int[] c) {
            int[][]  m = new int[2][c.length];
            // Arrays.fill(m[0],-1);
            //Arrays.fill(m[1],-1);
            int sumU=0,sumL=0;
            for(int i =0;i< c.length;i++){
                if(c[i]==0){
                    m[0][i]=0;
                    m[1][i]=0;
                }else if(c[i]==2){
                    m[0][i]=1;
                    m[1][i]=1;
                    sumU++;
                    sumL++;
                }

            }
            int su=u-sumU;
            int sl= l-sumL;
            for(int i =0;i< c.length;i++){
                if(c[i]==1&&su>0){
                    m[0][i]=1;
                    su--;
                } else if(c[i]==1&&sl>0){
                    m[1][i]=1;
                    sl--;
                }
            }
            if(su!=0||sl!=0){
                return "IMPOSSIBLE";
            }
            StringBuilder sb = new StringBuilder();
            for(int i =0;i< c.length;i++){
                sb.append(m[0][i]);
            }
            sb.append(",");
            for(int i =0;i< c.length;i++){
                sb.append(m[1][i]);
            }
            return sb.toString();
        }


    }

}
