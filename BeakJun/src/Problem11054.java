import java.io.*;

public class Problem11054 {

    public static void main(String[] args) throws IOException {
        int n= readInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dpRvs = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }

        for(int i=0; i<n; i++) {
            dp[i]=1;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int i=n-1; i>=0; i--) {
            dpRvs[i]=1;
            for(int j=n-1; j>i; j--) {
                if(arr[i] >  arr[j]) {
                    dpRvs[i] = Math.max(dpRvs[i], dpRvs[j]+1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dpRvs[i] + dp[i] -1);
        }

        System.out.println(answer);

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }

}
