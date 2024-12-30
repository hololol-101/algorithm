import java.io.*;

public class Problem1182 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int s = readInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }

        int res = backTracking(arr, 0, 0, s);
        System.out.println(res);
    }
    static int backTracking(int[]arr, int index, int sum, int value) {
        int res = 0;
        if(index == arr.length) {
            return res;
        }
        if(sum + arr[index] == value) {
            res += 1;
        }
        backTracking(arr, index + 1, sum + arr[index], value);
        backTracking(arr, index + 1, sum , value);
        return res;

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }

}
