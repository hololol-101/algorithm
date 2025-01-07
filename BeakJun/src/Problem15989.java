import java.io.*;

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        // input
        int n = readInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }

        for(int i=0; i<n; i++){
            System.out.println(collaborator(0, arr[i], 0));
        }

    }
    static int collaborator(int sum, int n, int value){
        int ans = 0;
        if(n==sum){
            return 1;
        }else if(sum > n){
            return 0;
        }
        if(value == 3 || value == 0){
            ans += collaborator(sum + 3, n, 3);
            ans += collaborator(sum + 2, n, 2);
            ans += collaborator(sum + 1, n, 1);
        }else if (value == 2){
            ans += collaborator(sum + 2, n, 2);
            ans += collaborator(sum + 1, n, 1);
        }else if (value == 1){
            return 1;
        }

        return ans;
    }
    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}



/*
n : 10 ans : 14

n : 20 ans : 44

n : 40 ans : 154

n : 80 ans : 574

n : 160 ans : 2214

n : 320 ans : 8694

n : 640 ans : 34454

n : 1280 ans : 137174

n : 2560 ans : 547414

n : 5120 ans : 2187094

 */