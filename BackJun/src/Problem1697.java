import java.util.*;
import java.io.*;

public class Problem1697 {
	static final int MAX = 200000;
	static int[] map;
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		br.close();
		
		int s = Integer.parseInt(arr[0]);
		int e = Integer.parseInt(arr[1]);
		
		
		//solution
		map = new int[MAX];
		
		int answer = dp(s, e);
		
		//output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+answer);
		bw.flush();
		bw.close();
		
	}
	static int dp(int s, int e) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			if(idx == e) {
				return map[idx];
			}			
			int nx=0;
			for(int i=0; i<3; i++) {
				switch(i) {
				case 0:
					nx = idx-1; break;
				case 1: 
					nx = idx+1; break;
				case 2: 
					nx = idx*2; break;
				}

				if(nx>=0 && nx<MAX && map[nx]==0) {
					map[nx] = map[idx]+1;
					queue.offer(nx);
				}
			}
		}
		return map[e];
	}
}
