import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

//23:15 - 23:32
public class Problem12761 {

	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]s = br.readLine().split(" ");
		br.close();
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int dong = Integer.parseInt(s[2]);
		int joo = Integer.parseInt(s[3]);
		int []map = new int[100001];
		
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(dong);
		map[dong]=0;
		//solution
		//dfs
		while(!que.isEmpty()&&map[joo]==0) {
			int idx = que.poll();
			int nx = 0;
			for(int i=0; i<8; i++) {
				switch(i) {
				case 0:
					nx = idx*a;
					break;
				case 1:
					nx = idx*b;
					break;
				case 2:
					nx = idx+a;
					break;
				case 3: 
					nx = idx+b;
					break;
				case 4:
					nx = idx+1;
					break;
				case 5:
					nx = idx-1;
					break;
				case 6:
					nx = idx-a;
					break;
				case 7:
					nx = idx-b;
					break;
				
				}
				if(nx<100001&&nx>=0&&map[nx]==0) {
					map[nx]= map[idx]+1;
					que.offer(nx);
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(map[joo]+"");
		bw.flush();
		bw.close();
		
		
	}

}
