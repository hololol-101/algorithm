import java.io.*;

public class Problem13458{

	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int []arr = new int[n];
		String[] str = br.readLine().split(" ");

		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		br.close();

		//solution
		long answer = 0l;
		for(int i:arr) {
			answer+=1;
			if(i<=m) {
				continue;
			}else {
				i-=m;
				answer += (i%s==0)?i/s:i/s+1;
			}
		}
		
		//output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+answer);
		bw.flush();
		bw.close();
		
	}

}
