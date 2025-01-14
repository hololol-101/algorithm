import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problem1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int line = Integer.parseInt(s[1]);
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        Long left = 0l;
        Long right = arr[0]+1;
        while(left < right) {
            Long mid = (left +right)/2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt < line) {
                right = mid;
            }else if(cnt >= line) {
                left = mid+1;
            }
        }
        System.out.println(left-1);
    }
}
