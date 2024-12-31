import java.io.*;
import java.util.StringTokenizer;

public class Problem10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];
        boolean[][] answer = new boolean[n+2][n+2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1 ; i<=n ;i++) {
            for(int j=i ; j>0 ; j--) {
                if(arr[i]==arr[j]) {
                    if(i-j<2 || answer[j+1][i-1]) answer[j][i]=true;
                }
            }
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int question = Integer.parseInt(br.readLine());
        for (int i = 0; i < question; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (answer[s][e]){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();

    }

}
