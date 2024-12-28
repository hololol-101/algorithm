import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem11659 {

    public static void main(String[] args) throws IOException {
        // input
        int n = readInt();
        int sol = readInt();
        int arr[] = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = readInt() + arr[i-1];
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i <sol; i++) {
            int st = readInt();
            int ed = readInt();
            String answer = Integer.toString(arr[ed]-arr[st-1]);
            bw.append(answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        if (c == 13) System.in.read();

        return n;

    }
}
