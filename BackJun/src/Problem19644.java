import java.util.Stack;
import java.io.*;
public class Problem19644 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int dist = Integer.parseInt(l[0]);
		int power = Integer.parseInt(l[1]);
		int boms = Integer.parseInt(bf.readLine());
		int[] zombies = new int[n];
		
		for(int i=0; i<n; i++) {
			zombies[i] = Integer.parseInt(bf.readLine());
		}
		
		System.out.println(solution(n, dist, power, boms, zombies));
		
		
		
		
	}
	
	static String solution(int n, int dist, int power, int bombs, int[] zombies) {
		String answer = "YES";
		Stack<Integer> stack = new Stack<>();
		
		int damage = 0 ;

		for(int i=0; i<n; i++) {
			int zombie = zombies[i];
			if(i<dist) {
				damage += power;					
			}				

			if(!stack.isEmpty()) {
				if(stack.peek()+dist<=i) {
					stack.pop();
				}
			}

			System.out.println(i+"번째 체력 - " + zombies[i] + " 데미지 - " + (damage-stack.size()*power));

			
			if(damage -stack.size()*power < zombie) {
				if(bombs>0) {
					bombs--;
					stack.push(i);
				}else {
					return "NO";
				}
			}


			
		}
		
		
		return answer;
	}
	
}
