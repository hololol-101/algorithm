import java.util.*;
import java.io.*;


//숨바꼭질 2
public class Problem12851 {
	static int s = 0;
	static int e = 0;
	static final int MAX = 200000;
	

	public static void main(String[] args) throws IOException{
		int count = 0;
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split(" ");
		br.close();
		
		s = Integer.parseInt(sarr[0]);
		e = Integer.parseInt(sarr[1]);
		int[] map = new int[200000];

		if(s==e) {
			count =1;
		}
		else {
			//solution
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(s);				
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(now == e) {
					break;
				}			
				for(int i=0; i<3; i++) {
					int next = 0;
					switch(i) {
					case 0:
						next = now*2;
						break;
					case 1:
						next = now+1;
						break;
					case 2:
						next = now-1;
						break;
					}
					if(next>=0 && next<MAX &&(now!=next)){
						
						if(map[next]==map[now]+1) {
							queue.offer(next);
							if(next == e) {
								count ++;
							}}
						if(map[next]==0) {
							map[next]=map[now]+1;
							queue.offer(next);
							if(next == e) {
								count ++;
							}}
					}
					
				}			
			}

		}
				
		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+map[e]);
		bw.newLine();
		bw.append(""+count);
		bw.flush();
		bw.close();
		
		
		
	}

}
