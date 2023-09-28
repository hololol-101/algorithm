import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

//25분
public class Problem17485 {
	static private int DIR = 3;
	public static void main(String[] args) throws IOException {
		int answer = Integer.MAX_VALUE;
		
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[]str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int [][][]arr = new int[n][m][DIR];
		for(int i=0; i<n; i++) {
			String[] cols = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				for(int k=0; k<DIR; k++) {
					arr[i][j][k]=Integer.parseInt(cols[j]);					
				}
			}						
		}
		
		br.close();

		
		//solution
		//세번째열 = 첫번째열 + 두번째열 + 세번째열
		//두번째열 = 첫번째열 + 두번째열 하고 세번째 열 구할때는 첫번째열 + 두번쩨열이 가장 작은 방향 제외하고 구하면 될듯?
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int d=0; d<DIR; d++) {
					switch(d) {
					case 0: //왼쪽 대각선으로 이동 
						if(j+1<m) {
							arr[i][j][d] += Math.min(arr[i-1][j+1][1], arr[i-1][j+1][2]);							
						}else {
							arr[i][j][d] = 1000001;
						}
						break;
					case 1: //중앙으로 이동
						arr[i][j][d] += Math.min(arr[i-1][j][0], arr[i-1][j][2]);
						break;
					case 2://오른쪽 대각선으로 이동 
						if(j>0) {
							arr[i][j][d] += Math.min(arr[i-1][j-1][0], arr[i-1][j-1][1]);							
						}else {
							arr[i][j][d] = 1000001;
						}
						break;
						
					}
				}
			}
		}
	
			
		for(int i=0; i<m; i++) {
			for(int j=0; j<DIR; j++) {
				answer = Math.min(arr[n-1][i][j], answer);
			}
		}
		//Output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.append(""+answer);
		bw.flush();
		bw.close();
		
	}
	

}

