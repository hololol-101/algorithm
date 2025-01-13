import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Problem2776 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = readInt();

        for (int i = 0; i < n; i++) {
            int n1 = readInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n1; j++) {
                set.add(readInt());
            }
            int n2 = readInt();
            for (int j = 0; j < n2; j++) {
                if (set.contains(readInt())) {
                    bw.write(1+ "\n");
                }else{
                    bw.write(0+ "\n");
                }
            }

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
