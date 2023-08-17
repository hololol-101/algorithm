import java.util.*;
import java.io.*;


//숨바꼭질 2
public class Problem12851 {
	static int s = 0;
	static int e = 0;
	static final int MAX = 200000;
	
	static class Log{
		int min = 0;
		int count = 0;
		
		Log(int min){
			this.min = min;
		}
		Log(int min, int count){
			this.min = min;
			this.count = count;
		}
		void cntInc(int count) {
			this.count += count;
		}
	}
	public static void main(String[] args) throws IOException{
		String answer = "";
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split(" ");
		br.close();
		
		s = Integer.parseInt(sarr[0]);
		e = Integer.parseInt(sarr[1]);
		Log[] map = new Log[200000];
		
		if(s==e) {
			answer = "0 1";
		}
		else {
			//solution
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(s);
			map[s] = new Log(0, 1);
				
			
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
					if(next>=0 && next<MAX) {
						Log nowLog = map[now];
						Log nextLog = map[next];
						
						if(nextLog==null) {
							nextLog = new Log(nowLog.min+1);
							nextLog.cntInc(nowLog.count);
							map[next] = nextLog;
							queue.offer(next);
						}
						else if(nextLog.min == nowLog.min+1) {
							nextLog.cntInc(nowLog.count);
							map[next] = nextLog;
						}
					}
					
				}			
			}
			answer += map[e].min +" "+map[e].count;		
		}
				
		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(answer);
		bw.flush();
		bw.close();
		
		
		
	}

}
