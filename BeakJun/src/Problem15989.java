import java.io.*;

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        // input
        int n = readInt();
        int[] arr = new int[10001];
        int[][]dp = new int[10001][4];



        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        setDp(dp);
        for (int i = 0; i < n; i++) {
            System.out.println(dp[arr[i]][0]);
        }

    }

    static void setDp(int[][] arr) {
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[2][0] = 2;
        arr[2][1] = arr[1][1];
        arr[2][2] = 1;
        arr[3][0] = 3;
        arr[3][1] = arr[2][1];
        arr[3][2] = arr[1][1]+arr[1][2];
        arr[3][3] = 1;

        for (int i = 4; i < arr.length; i++) {
            arr[i][1] = arr[i - 1][1];
            arr[i][2] = arr[i - 2][1] + arr[i - 2][2];
            arr[i][3] = arr[i - 3][1] + arr[i - 3][2] + arr[i - 3][3];
            arr[i][0] = arr[i][1] + arr[i][2] + arr[i][3];
        }

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