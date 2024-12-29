import java.io.*;
import java.util.Arrays;

public class Problem2529 {
    static String max = "00";
    static String min = "99";
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().replace(" ", "").toCharArray();

        int[] answer = new int[n+1];
        //test
        for (int i = 0; i < 10; i++) {
            answer[0] = i;
            bf(cs, answer, n, 0);
        }

        // output
        System.out.println(max);
        System.out.println(min);

    }
    static void bf(char[] chars, int[] answer, int size, int index) {
        if(size == index){
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < size+1; i++){
                result.append(answer[i]);
            }
            String s = result.toString();
            min = (min.compareTo(s)<0)? min : s;
            max = max.compareTo(s)>0?max : s;
            return;
        }
        if (chars[index] == '<') {
            for (int i = answer[index] + 1; i <10; i++) {
                boolean check = true;
                for (int j = 0; j <= index; j++) {
                    if(answer[j] == i){
                        check = false;
                        break;
                    }
                }
                if(check){
                    answer[index+1] = i;
                    bf(chars, answer, size, index+1);
                }
            }
        }else{
            for (int i = answer[index] - 1; i >= 0; i--) {
                boolean check = true;
                for (int j = 0; j <= index; j++) {
                    if(answer[j] == i){
                        check = false;
                        break;
                    }
                }
                if(check){
                    answer[index+1] = i;
                    bf(chars, answer, size, index+1);
                }
            }
        }

    }

}
