import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;


public class Problem18353 {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		//Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int[]arr = new int[n];
		int[]dp= new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		//solution
		for(int i=1; i<n; i++) {
			int max = 1;

			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i]) {
					max = Math.max(max, dp[j]+1);
				}
			}
			dp[i]=max;
		}

		for(int i:dp) {
			answer = Math.max(answer, i);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		bw.append(""+(n-answer));
		bw.flush();
		
		bw.close();
		
	}

}

