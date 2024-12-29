import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem2579 {
    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        //test
        long dp[] = new long[n];
        dp[0] = arr[0];
        if(n>1){
            dp[1] = arr[0] + arr[1];
        }
        if(n>2){
            dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        }

        //dp[i][0] 은 이전 다리는 건너뛰고 지금 다리를 밟음
        //dp[i][1] 은 이전 다리를 밟고 지금 다리도 밟음
        for (int i = 3; i < n; i++) {
            dp[i] = arr[i] + Math.max(dp[i-2], arr[i-1]+dp[i-3]);
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(Long.toString(dp[n-1]));
        bw.flush();
        bw.close();
    }

}
