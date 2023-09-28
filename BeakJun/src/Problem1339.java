import java.util.*;

public class Problem1339 {

	public static void main(String[] args) {
		int answer = 0;

		// Input
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] s = new String[n];
		
		for(int i=0; i<n; i++) {
			s[i] = sc.nextLine();
		}

		sc.close();
		

		HashMap<String, Integer> hm =  new HashMap<>();


		for(String str: s) {
			String[] chars = str.split("");
			int size = chars.length;
			for(int i=0; i<size; i++) {
				String c = chars[i];
				hm.put(c, (int) (hm.getOrDefault(c,0)+Math.pow(10, size-1-i)));
			}
		}
		
		Iterator<String> it = hm.keySet().iterator();
		int[] arr = new int[hm.size()];
		
		for(int i=0; i<hm.size(); i++) {
			arr[i] = hm.get(it.next());
		}
		Arrays.sort(arr);
		int min = 9-hm.size()+1;
		for(int i=0; i<arr.length; i++) {
			answer += min * arr[i];
			min++;
		}
		System.out.println(answer);
	}

}
