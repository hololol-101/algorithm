import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem9095 {
    private static final int CASE = 4;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        br.close();

        int dp[] = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4; i<=max; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            bw.append(String.valueOf(dp[arr[i]]));
            bw.append("\n");
        }
        bw.flush();
        bw.close();
    }

}
