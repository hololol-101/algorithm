import java.util.*;
import java.io.*;

public class Problem2141 {
	static class Node implements Comparable<Node>{
		int pos;
		int cnt;
		
		Node(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.pos - n.pos;
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		Long total = 0l;
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n];

		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			int pos = Integer.parseInt(str[0]);
			int cnt = Integer.parseInt(str[1]);

			nodes[i] = new Node(pos, cnt);
			
			total += cnt;
		}

		br.close();
				
		Arrays.sort(nodes);
		
		Long sum = 0l;
		for(int i=0; i<n; i++) {
			sum+=nodes[i].cnt;
			
			if(sum>=(total+1)/2) {
				System.out.println(nodes[i].pos);
				return ;
			}
		}
		
	}
}
