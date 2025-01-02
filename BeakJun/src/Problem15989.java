import java.io.*;

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int max=0;
        for(int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            max=Math.max(max,arr[i]);
        }

        int[]dp = new int[max+1];
        for(int i = 1; i <=max; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i > 5) {
                if (i % 2 == 0 || i % 3 == 0) {
                    dp[i] += 1;
                }

            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            bw.write(dp[arr[i]]+"\n");
        }
        bw.flush();
        bw.close();

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}



/*
n : 10 ans : 14

n : 20 ans : 44

n : 40 ans : 154

n : 80 ans : 574

n : 160 ans : 2214

n : 320 ans : 8694

n : 640 ans : 34454

n : 1280 ans : 137174

n : 2560 ans : 547414

n : 5120 ans : 2187094

 */