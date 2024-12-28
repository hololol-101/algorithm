import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem1149 {
    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][3];
        for(int i = 1; i <= n; i++) {
            String []s = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        br.close();

        //test
        int dp[][] = new int[n+1][3];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        for(int i = 2; i <= n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(Integer.toString(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2])));
        bw.flush();
        bw.close();
    }

}
