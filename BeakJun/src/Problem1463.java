import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem1463 {
    private static final int CASE = 4;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        //test

        int arr[] = new int[n+1];
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
        System.out.println(arr[n]);
    }

}
