import java.io.*;

public class Problem11060 {
    public static void main(String[] args) throws IOException {
        //input 2 - 숫자와 스페이스, 엔터로만 이루어져 있을때
        int n = readInt();
        int[] arr = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (i != 0 && cnt[i] == 0) {
                continue;
            }
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j >= n) {
                    break;
                }
                if (cnt[i + j] != 0) {
                    cnt[i + j] = Math.min(cnt[i] + 1, cnt[i + j]);
                } else {
                    cnt[i + j] = cnt[i] + 1;
                }

            }
        }

        // output
        if(n==1){
            System.out.println(cnt[0]);
        }else if (cnt[n - 1] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(cnt[n - 1]);
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