import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Problem1543 {

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String total = br.readLine();
        String word = br.readLine();
        br.close();
        int n = 0;
        int cnt = 0;
        if (!total.contains(word)) {
            System.out.println("0");
        }else{

            while (total.indexOf(word, n)>=0){
                n = total.indexOf(word, n) + word.length();
                cnt++;
            }
            System.out.println(cnt);
        }
    }

}
