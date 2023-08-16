import java.io.*;
import java.util.Arrays;

public class Problem2212 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sensorNum = Integer.parseInt(bf.readLine());
		int center = Integer.parseInt(bf.readLine());
		int[] sensors = new int[sensorNum];

		String[] tmp = bf.readLine().split(" ");
		bf.close();
		
		for(int i=0; i<sensorNum; i++) {
			sensors[i] = Integer.parseInt(tmp[i]);
		}

		Arrays.sort(sensors);

		int answer = solution(sensorNum, center, sensors);
		
		System.out.print(answer);
	}
	static int solution(int snum, int cnum, int[] sensors) {
		int answer = 0;
		if(snum<=cnum) {
			return answer;
		}
		
		int[] dif = new int[snum-1];
		
		for(int i=0; i<snum-1; i++) {
			dif[i] = sensors[i+1]-sensors[i];
		}
		
		Arrays.sort(dif);
		for(int i=0; i<snum-cnum; i++) {
			answer += dif[i];
		}
		
		return answer;
	}

}
