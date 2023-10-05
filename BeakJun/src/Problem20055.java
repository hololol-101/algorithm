import java.util.*;
import java.io.*;

public class Problem20055 {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		int size = 2*n;
		int[] arr = new int[size];
		boolean[] check = new boolean[size];

		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		//test	
		int put = 0;
		int answer = 0;
				
		int cnt = 0;
		
		while(cnt<total) {
			answer++;
			
			//레일 이동
			put=(put-1+size)%size;
			int get = (put-1+n)%size;

			if(check[get]) {
				check[get]=false;
			}
			
			//가능한 아이들 1칸씩 이동
			for(int i=1; i<size; i++) {
				int idx = (get-i+size)%size;
				int nidx = (get-i+1+size)%size;
				if(check[idx]&&!check[nidx]&&arr[nidx]>0) {
					check[idx]=false;
					check[nidx]=true;
					arr[nidx]-=1;
				}
			}

			if(check[get]) {
				check[get]=false;
			}
			
			if(arr[put]>0) {
				arr[put]-=1;
				check[put]=true;
			}
		
			cnt=0;
			for(int i=0; i<size; i++) {
				if(arr[i]==0) {
					cnt++;
				}
			}
		}
		
		
		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(answer+"");
		bw.flush();
		bw.close();

	}

}
