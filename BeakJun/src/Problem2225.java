import java.io.*;

public class Problem2225 {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k =  readInt();

        long [][]dp = new long[n+1][k+1];
        final long mod = 1000000000;

        //초기 세팅
        for(int i=0; i<=n; i++){
            dp[i][1] = 1;
        }
        for(int i=1; i<k+1; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<k+1; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%mod;
            }
        }
        System.out.println(dp[n][k]);

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}