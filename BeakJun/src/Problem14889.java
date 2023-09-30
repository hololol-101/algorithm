import java.io.*;
import java.util.StringTokenizer;

public class Problem14889 {
	static int[][] arr;
	static boolean[]check;
	static int n;
	public static void main(String[] args) throws IOException{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());				
			}
		}
		br.close();
				
		//solution
		int answer = reculsion(0, 0);

		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+answer);
		bw.flush();
		bw.close();

	}
	static int reculsion(int cnt, int index) {

		if(cnt == n/2){
			int answer = 0;
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if(check[i]&&check[j]) {
						answer+=arr[i][j];
						answer+=arr[j][i];
					}else if(!check[i]&&!check[j]) {
						answer-=arr[i][j];
						answer-=arr[j][i];
					}
				}
			}
			return Math.abs(answer);
		}else if(index==n) {
			return Integer.MAX_VALUE;
		}
		else {
			int answer = Integer.MAX_VALUE;
			check[index]=true;
			answer =  Math.min(reculsion(cnt+1, index+1), answer);
			if(answer ==0) return answer;

			check[index]=false;
			answer = Math.min(reculsion(cnt, index+1), answer);
			return answer;
		}		
	}
}
