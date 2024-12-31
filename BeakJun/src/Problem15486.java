import java.io.*;

public class Problem15486 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[][]arr = new int[n+2][2];
        int[]sum = new int[n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = readInt();
            }
        }
        //test
        for (int i = 1; i <= n+1; i++) {
            int time = arr[i][0];
            int value = arr[i][1];
            sum[i] = Math.max(sum[i-1], sum[i]);
            if(i+time <= n+1){
                sum[i+time] = Math.max(sum[i+time], sum[i]+value);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n+1; i++) {
            max = Math.max(max, sum[i]);
        }
        // output
        System.out.println(max);

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }

}
