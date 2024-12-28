import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem12852 {

    public static void main(String[] args) throws IOException {

        int n = readInt();

        //test

        int arr[] = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[1] = 0;
        for (int i = 1; i <=n; i++) {
            if(i*3<=n){
                arr[i*3] = Math.min(arr[i*3], arr[i]+1);
            }
            if(i*2<=n) {
                arr[i * 2] = Math.min(arr[i*2], arr[i]+1);
            }
            if(i+1 <=n){
                arr[i+1] = Math.min(arr[i+1], arr[i]+1);
            }
        }
        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(Integer.toString(arr[n]));
        bw.append('\n');

        while(n>1){
            bw.write(n + " ");
            if(n%3==0 && arr[n/3] < arr[n]){
                n/=3;
            }else if (n%2==0 && arr[n/2] < arr[n]){
                n/=2;
            }else{
                n--;
            }
        }
        bw.write("1");
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
