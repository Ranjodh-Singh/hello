import java.util.Arrays;

/*
There are N bulbs, numbered from 1 to N, arranged in a row. Initially,
all the bulbs are turned off. At moment K (for K from 0 to N - 1), we turn on the A[K]-th bulb. A bulb shines
 if it is on and all the previous bulbs are turned on too.
Return the number of moments for which every turned on bulb shines
 */
public class LightBulbCodility {

    public static void main(String[] args) {
        int[] nums1 = {2,1,3,5,4};//3
        int[] nums2 = {2,3,4,1,5};//2
        int[] nums3 = {1,3,4,2,5};//3
        int[] nums4 = {3,2,4,6,5};//3
        System.out.println(getNumOfMoments(nums1));
        System.out.println(getNumOfMoments(nums2));
        System.out.println(getNumOfMoments(nums3));
        System.out.println(getNumOfMoments(nums4));
    }
    private static int getNumOfMoments(int[] nums) {
        int[] preSumNums = new int[nums.length + 1];
        int[] preSumNumsSorted = new int[nums.length + 1];
        int[] numsSorted = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            preSumNums[i+1] = preSumNums[i] + nums[i];
            preSumNumsSorted[i+1] = preSumNumsSorted[i] + numsSorted[i];
            if(preSumNums[i+1] == preSumNumsSorted[i+1])
                res++;
        }
        return res;
    }
}
