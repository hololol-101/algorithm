import java.io.*;
import java.util.Arrays;

public class Problem11663 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        long []arr = new long[n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        Arrays.sort(arr);

        for(int i = 0; i < m; i++) {
            int answer = 0;
            String[]s = br.readLine().split(" ");
            long start = Long.parseLong(s[0]);
            long end = Long.parseLong(s[1]);
            int idx = 0;
            int edx = arr.length - 1;
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j]<start&&start<=arr[j+1]){
                    idx = j;
                    break;
                }
            }
            for(int j = arr.length-1; j>0 ; j--) {
                if(arr[j]>=end&&end>arr[j-1]){
                    edx = j;
                    break;
                }
            }

            System.out.println(edx - idx + 1);
        }

        //test

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append("");
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
