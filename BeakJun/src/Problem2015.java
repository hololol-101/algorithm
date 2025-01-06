import java.io.*;
import java.util.HashMap;

public class Problem2015 {
    public static void main(String[] args) throws IOException {
        //input
        int n = readInt();
        int k = readInt();
        int[]arr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i]=readInt();
        }

        //test
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int sum = arr[i];
            for(int j = i; j < n; j++) {
                sum+=arr[j];
                if(sum==k){
                    map.put(i,j);
                }else{
                    break;
                }
            }
        }
        // output
        System.out.println(map.size());

    }


    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}
