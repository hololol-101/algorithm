import java.io.*;

public class Problem14888{
	static long max = Integer.MIN_VALUE;
	static long min = Integer.MAX_VALUE;
	static int[] num;
	static int[] math;
	//14888
	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		math = new int[4];

		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		
		str = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			math[i] = Integer.parseInt(str[i]);
		}
		
		br.close();

	
		//solution
		reculsion(num[0], 1);
			
		//output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+max);
		bw.newLine();
		bw.append(""+min);
		bw.close();
		bw.close();
		
	}
	
	public static void reculsion(long tot, int index ) {
		if(index==num.length) {
			min = (min<tot)?min:tot;
			max = (max>tot)?max:tot;			
		}else {
			for(int i=0; i<4; i++) {
				if(math[i]>0) {
					math[i]--;
					long nexttot = tot;
					switch(i) {
					case 0:
						nexttot+=num[index];
						break;
					case 1:
						nexttot-=num[index];
						break;
					case 2:
						nexttot*=num[index];
						break;
					case 3:
						nexttot/=num[index];
						break;
					}
					reculsion(nexttot, index+1);
					math[i]++;
				}
			}			
		}
	}
}
