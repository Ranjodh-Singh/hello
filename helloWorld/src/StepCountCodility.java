public class StepCountCodility {
    /**
     * https://stackoverflow.com/questions/39588554/minimum-number-of-steps-to-reduce-number-to-1
     *  but we reduce it to 0 given binary string and we have two operations only  divide by 2 or -1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(stepCount(Integer.parseInt("011100",2)));
    }
   static int stepCount(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 0)                // bitmask: *0
                n = n / 2;
            else if (n == 3 || n % 4 == 1) // bitmask: 01
                n = n - 1;
            else                           // bitmask: 11
                n = n - 1;
            count += 1;
        }
        return count;
    }
}
